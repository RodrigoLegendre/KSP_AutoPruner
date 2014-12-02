package almightyr;

import java.io.File;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import static almightyr.Util.*;
import javax.swing.tree.TreePath;

/**
 *
 * @author Rodrigo Legendre Lima Rodrigues
 */
public class Main extends javax.swing.JFrame {

    public static final File BASE_DIR = new File(System.getProperty("user.dir"));

    //@TODO: Make these dynamic.
    public static File GAMEDATA_DIR = new File(BASE_DIR.getParentFile().getAbsolutePath() + "/GameData");
    public static File DISABLED_FILES_DIR = new File(BASE_DIR.getAbsolutePath() + "/_Disabled");

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();

        //Reset models and populate with present files.
        //@NOTE: Moved this code to the pre-init. Still searching for ways to replace NetBeans' GUI editor's default init code for the JTree models.
        //Remove nodes from GameData tree if they are present at DisabledFiles tree.
        TreeModel_FullPathExchange enabledModel = (TreeModel_FullPathExchange) jTree_GameDataTree.getModel();
        TreeModel_FullPathExchange disabledModel = (TreeModel_FullPathExchange) jTree_DisabledFilesTree.getModel();
//        for (DefaultMutableTreeNode node : getLeafNodesList((DefaultMutableTreeNode) disabledModel.getRoot())) {
        for (DefaultMutableTreeNode node : getLeafNodesList((DefaultMutableTreeNode) disabledModel.getRoot())) {
            DefaultMutableTreeNode reusableNode = enabledModel.getReusableNode(node);
            if (reusableNode.getLevel() == node.getLevel()) {
                enabledModel.removeNodeFromParent(reusableNode);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel_DirectControlTab = new javax.swing.JPanel();
        jPanel_EnabledPanel = new javax.swing.JPanel();
        jScrollPane_GameDataTree = new javax.swing.JScrollPane();
        jTree_GameDataTree = new javax.swing.JTree();
        jPanel_DisabledPanel = new javax.swing.JPanel();
        jScrollPane_DisabledFilesTree = new javax.swing.JScrollPane();
        jTree_DisabledFilesTree = new javax.swing.JTree();
        jPanel_CenterAreaPanel = new javax.swing.JPanel();
        jPanel_DirectControl = new javax.swing.JPanel();
        jButton_DirectDisable = new javax.swing.JButton();
        jButton_DirectEnable = new javax.swing.JButton();
        jButton_Apply = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();
        jPanel_ListControl = new javax.swing.JPanel();
        jComboBox_ListSelect = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree_ListTree = new javax.swing.JTree();
        jButton_ListLoad = new javax.swing.JButton();
        jButton_ListSave = new javax.swing.JButton();
        jButton_ListEnableAll = new javax.swing.JButton();
        jButton_ListDisableAll = new javax.swing.JButton();
        jButton_ListEnable = new javax.swing.JButton();
        jButton_ListDisable = new javax.swing.JButton();
        jButton_GameDataToList = new javax.swing.JButton();
        jButton_DisabledToList = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KSP AutoPruner");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel_EnabledPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createTitledBorder("GameData files:")));
        jPanel_EnabledPanel.setPreferredSize(new java.awt.Dimension(200, 371));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree_GameDataTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree_GameDataTree.setToolTipText("This file-tree shows the files that are currently enabled.");
        jTree_GameDataTree.setRootVisible(false);
        jTree_GameDataTree.setModel(new TreeModel_FullPathExchange(getNodeFromFile(GAMEDATA_DIR)));
        jScrollPane_GameDataTree.setViewportView(jTree_GameDataTree);

        javax.swing.GroupLayout jPanel_EnabledPanelLayout = new javax.swing.GroupLayout(jPanel_EnabledPanel);
        jPanel_EnabledPanel.setLayout(jPanel_EnabledPanelLayout);
        jPanel_EnabledPanelLayout.setHorizontalGroup(
            jPanel_EnabledPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_GameDataTree, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );
        jPanel_EnabledPanelLayout.setVerticalGroup(
            jPanel_EnabledPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_GameDataTree)
        );

        jPanel_DisabledPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createTitledBorder("Disabled files:")));
        jPanel_DisabledPanel.setPreferredSize(new java.awt.Dimension(200, 371));

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree_DisabledFilesTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree_DisabledFilesTree.setToolTipText("This file-tree shows the files that are currently disabled.");
        jTree_DisabledFilesTree.setRootVisible(false);
        jTree_DisabledFilesTree.setModel(new TreeModel_FullPathExchange(getNodeFromFile(DISABLED_FILES_DIR)));
        jScrollPane_DisabledFilesTree.setViewportView(jTree_DisabledFilesTree);

        javax.swing.GroupLayout jPanel_DisabledPanelLayout = new javax.swing.GroupLayout(jPanel_DisabledPanel);
        jPanel_DisabledPanel.setLayout(jPanel_DisabledPanelLayout);
        jPanel_DisabledPanelLayout.setHorizontalGroup(
            jPanel_DisabledPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_DisabledFilesTree, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );
        jPanel_DisabledPanelLayout.setVerticalGroup(
            jPanel_DisabledPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_DisabledFilesTree)
        );

        jPanel_CenterAreaPanel.setLayout(new java.awt.GridBagLayout());

        jPanel_DirectControl.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createTitledBorder("Direct Control:")));
        jPanel_DirectControl.setLayout(new java.awt.GridBagLayout());

        jButton_DirectDisable.setText(">>>");
        jButton_DirectDisable.setToolTipText("Disable selected file.");
        jButton_DirectDisable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DirectDisableActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel_DirectControl.add(jButton_DirectDisable, gridBagConstraints);

        jButton_DirectEnable.setText("<<<");
        jButton_DirectEnable.setToolTipText("Enable selected file.");
        jButton_DirectEnable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DirectEnableActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel_DirectControl.add(jButton_DirectEnable, gridBagConstraints);

        jButton_Apply.setText("Apply");
        jButton_Apply.setToolTipText("Apply changes to files.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_DirectControl.add(jButton_Apply, gridBagConstraints);

        jButton_Cancel.setText("Cancel");
        jButton_Cancel.setToolTipText("Cancel changes to files.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_DirectControl.add(jButton_Cancel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel_CenterAreaPanel.add(jPanel_DirectControl, gridBagConstraints);

        jPanel_ListControl.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createTitledBorder("List Control:")));
        jPanel_ListControl.setLayout(new java.awt.GridBagLayout());

        jComboBox_ListSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_ListSelect.setToolTipText("List selection menu.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel_ListControl.add(jComboBox_ListSelect, gridBagConstraints);

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("GameData");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Mod 1");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Parts");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Part 1");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Part 2");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Part 3");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Mod 2");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Parts");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Part 1");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Part 2");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Part 3");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Mod 3");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Parts");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Part 1");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Part 2");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Part 3");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree_ListTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree_ListTree.setToolTipText("This file-tree shows the files that the currently selected list contains.");
        jTree_ListTree.setRootVisible(false);
        jScrollPane1.setViewportView(jTree_ListTree);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        jPanel_ListControl.add(jScrollPane1, gridBagConstraints);

        jButton_ListLoad.setText("Load");
        jButton_ListLoad.setToolTipText("Load selected List.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel_ListControl.add(jButton_ListLoad, gridBagConstraints);

        jButton_ListSave.setText("Save");
        jButton_ListSave.setToolTipText("Save selected List.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel_ListControl.add(jButton_ListSave, gridBagConstraints);

        jButton_ListEnableAll.setText("Enable All");
        jButton_ListEnableAll.setToolTipText("Enable all files in the current List.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel_ListControl.add(jButton_ListEnableAll, gridBagConstraints);

        jButton_ListDisableAll.setText("Disable All");
        jButton_ListDisableAll.setToolTipText("Disable all files in the current List.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel_ListControl.add(jButton_ListDisableAll, gridBagConstraints);

        jButton_ListEnable.setText("<<<");
        jButton_ListEnable.setToolTipText("Enable selected List file.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel_ListControl.add(jButton_ListEnable, gridBagConstraints);

        jButton_ListDisable.setText(">>>");
        jButton_ListDisable.setToolTipText("Disable selected List file.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel_ListControl.add(jButton_ListDisable, gridBagConstraints);

        jButton_GameDataToList.setText(">");
        jButton_GameDataToList.setToolTipText("Add selected GameData file to this List.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel_ListControl.add(jButton_GameDataToList, gridBagConstraints);

        jButton_DisabledToList.setText("<");
        jButton_DisabledToList.setToolTipText("Add selected Disabled file to this List.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel_ListControl.add(jButton_DisabledToList, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel_CenterAreaPanel.add(jPanel_ListControl, gridBagConstraints);

        javax.swing.GroupLayout jPanel_DirectControlTabLayout = new javax.swing.GroupLayout(jPanel_DirectControlTab);
        jPanel_DirectControlTab.setLayout(jPanel_DirectControlTabLayout);
        jPanel_DirectControlTabLayout.setHorizontalGroup(
            jPanel_DirectControlTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DirectControlTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_EnabledPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_CenterAreaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_DisabledPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel_DirectControlTabLayout.setVerticalGroup(
            jPanel_DirectControlTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DirectControlTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_DirectControlTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_EnabledPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addComponent(jPanel_DisabledPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addComponent(jPanel_CenterAreaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel_DirectControlTab, "card3");

        jMenu1.setText("File");

        jMenuItem1.setText("Quit");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("About");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_DirectDisableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DirectDisableActionPerformed
        List<DefaultMutableTreeNode> selectedNodes = getSelectedTreeNodes(jTree_GameDataTree);
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) jTree_DisabledFilesTree.getModel().getRoot();

        TreeModel_FullPathExchange outModel = (TreeModel_FullPathExchange) jTree_GameDataTree.getModel();
        TreeModel_FullPathExchange inModel = (TreeModel_FullPathExchange) jTree_DisabledFilesTree.getModel();
        for (DefaultMutableTreeNode aSelectedNode : selectedNodes) {
            outModel.exchangeNodeOut(aSelectedNode, inModel);
        }

        //Show last added node
        TreePath treePath = new TreePath(outModel.getLastOutgoingNode().getPath());
        jTree_DisabledFilesTree.expandPath(treePath);
        jTree_GameDataTree.scrollPathToVisible(treePath);
    }//GEN-LAST:event_jButton_DirectDisableActionPerformed

    private void jButton_DirectEnableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DirectEnableActionPerformed
        List<DefaultMutableTreeNode> selectedNodes = getSelectedTreeNodes(jTree_DisabledFilesTree);
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) jTree_GameDataTree.getModel().getRoot();

        TreeModel_FullPathExchange outModel = (TreeModel_FullPathExchange) jTree_DisabledFilesTree.getModel();
        TreeModel_FullPathExchange inModel = (TreeModel_FullPathExchange) jTree_GameDataTree.getModel();
        for (DefaultMutableTreeNode aSelectedNode : selectedNodes) {
            outModel.exchangeNodeOut(aSelectedNode, inModel);
        }

        //Show last added node
        TreePath treePath = new TreePath(outModel.getLastOutgoingNode().getPath());
        jTree_DisabledFilesTree.expandPath(treePath);
        jTree_GameDataTree.scrollPathToVisible(treePath);
    }//GEN-LAST:event_jButton_DirectEnableActionPerformed

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("Convert2Lambda")
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Apply;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_DirectDisable;
    private javax.swing.JButton jButton_DirectEnable;
    private javax.swing.JButton jButton_DisabledToList;
    private javax.swing.JButton jButton_GameDataToList;
    private javax.swing.JButton jButton_ListDisable;
    private javax.swing.JButton jButton_ListDisableAll;
    private javax.swing.JButton jButton_ListEnable;
    private javax.swing.JButton jButton_ListEnableAll;
    private javax.swing.JButton jButton_ListLoad;
    private javax.swing.JButton jButton_ListSave;
    private javax.swing.JComboBox jComboBox_ListSelect;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel_CenterAreaPanel;
    private javax.swing.JPanel jPanel_DirectControl;
    private javax.swing.JPanel jPanel_DirectControlTab;
    private javax.swing.JPanel jPanel_DisabledPanel;
    private javax.swing.JPanel jPanel_EnabledPanel;
    private javax.swing.JPanel jPanel_ListControl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane_DisabledFilesTree;
    private javax.swing.JScrollPane jScrollPane_GameDataTree;
    private javax.swing.JTree jTree_DisabledFilesTree;
    private javax.swing.JTree jTree_GameDataTree;
    private javax.swing.JTree jTree_ListTree;
    // End of variables declaration//GEN-END:variables
}