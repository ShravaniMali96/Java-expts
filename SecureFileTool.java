import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.Base64;

public class SecureFileTool extends JFrame {
    private JTextField filePathField, descriptionField;
    private JTextArea statusArea;
    private File selectedFile;

    public SecureFileTool() {
        setTitle("Secure File Tool - Encryption & Metadata");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    // Member 1 - UI setup
    private void initUI() {
        JLabel fileLabel = new JLabel("Select File:");
        filePathField = new JTextField(30);
        JButton browseButton = new JButton("Browse");

        JLabel descLabel = new JLabel("File Description:");
        descriptionField = new JTextField(30);

        JButton encryptButton = new JButton("Encrypt");
        JButton decryptButton = new JButton("Decrypt");

        statusArea = new JTextArea(10, 50);
        statusArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statusArea);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(fileLabel, gbc);
        gbc.gridx = 1;
        panel.add(filePathField, gbc);
        gbc.gridx = 2;
        panel.add(browseButton, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(descLabel, gbc);
        gbc.gridx = 1;
        panel.add(descriptionField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(encryptButton, gbc);
        gbc.gridx = 1;
        panel.add(decryptButton, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 3;
        panel.add(scrollPane, gbc);

        add(panel);

        browseButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                filePathField.setText(selectedFile.getAbsolutePath());
            }
        });

        // Member 4 - Integration
        encryptButton.addActionListener(e -> {
            if (selectedFile != null && !descriptionField.getText().isEmpty()) {
                try {
                    SecretKey key = generateAESKey();
                    encryptFile(selectedFile, key);
                    saveKeyFile(key, selectedFile);
                    saveMetadata(selectedFile, descriptionField.getText());
                    statusArea.append("File encrypted and metadata saved.\n");
                } catch (Exception ex) {
                    statusArea.append("Encryption Error: " + ex.getMessage() + "\n");
                }
            } else {
                statusArea.append("Please select a file and enter a description.\n");
            }
        });

        decryptButton.addActionListener(e -> {
            if (selectedFile != null) {
                try {
                    SecretKey key = loadKeyFile(selectedFile);
                    decryptFile(selectedFile, key);
                    String desc = readMetadata(selectedFile);
                    statusArea.append("File decrypted successfully.\nDescription: " + desc + "\n");
                } catch (Exception ex) {
                    statusArea.append("Decryption Error: " + ex.getMessage() + "\n");
                }
            } else {
                statusArea.append("Please select a file to decrypt.\n");
            }
        });
    }

    // Member 2 - AES encryption
    private SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128-bit AES
        return keyGen.generateKey();
    }

    private void encryptFile(File inputFile, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] fileData = Files.readAllBytes(inputFile.toPath());
        byte[] encryptedData = cipher.doFinal(fileData);

        FileOutputStream fos = new FileOutputStream(inputFile.getAbsolutePath() + ".enc");
        fos.write(encryptedData);
        fos.close();
    }

    private void decryptFile(File encryptedFile, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] fileData = Files.readAllBytes(encryptedFile.toPath());
        byte[] decryptedData = cipher.doFinal(fileData);

        String outPath = encryptedFile.getAbsolutePath().replace(".enc", ".dec");
        FileOutputStream fos = new FileOutputStream(outPath);
        fos.write(decryptedData);
        fos.close();
    }

    private void saveKeyFile(SecretKey key, File file) throws IOException {
        String encoded = Base64.getEncoder().encodeToString(key.getEncoded());
        FileWriter writer = new FileWriter(file.getAbsolutePath() + ".key");
        writer.write(encoded);
        writer.close();
    }

    private SecretKey loadKeyFile(File file) throws Exception {
        String keyPath = file.getAbsolutePath().replace(".enc", ".key");
        byte[] encoded = Files.readAllBytes(Paths.get(keyPath));
        byte[] decoded = Base64.getDecoder().decode(new String(encoded));
        return new SecretKeySpec(decoded, "AES");
    }

    // Member 3 - Metadata handling
    private void saveMetadata(File file, String description) throws IOException {
        String metaPath = file.getAbsolutePath() + ".meta";
        FileWriter writer = new FileWriter(metaPath);
        writer.write(description);
        writer.close();
    }

    private String readMetadata(File file) throws IOException {
        String metaPath = file.getAbsolutePath().replace(".enc", ".meta");
        return new String(Files.readAllBytes(Paths.get(metaPath)));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SecureFileTool().setVisible(true));
    }
}