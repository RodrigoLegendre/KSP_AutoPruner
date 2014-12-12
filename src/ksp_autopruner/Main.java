package ksp_autopruner;

import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Rodrigo Legendre Lima Rodrigues
 */
public class Main extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="Folder Structure Variables">
    public static final File BASE_DIR = new File(System.getProperty("user.dir"));

    //@TODO: Make GameData directory location dynamic
    public static File gameDataDir = new File(BASE_DIR.getParentFile().getAbsolutePath() + "/GameData");

    public static File disabledFilesDir = new File(BASE_DIR.getAbsolutePath() + "/_Disabled");
    //@NODE: This will probably be the base dir on the public release. '_Lists' is being used to better organize the project during testing.
    public static File pruneListsDir = new File(BASE_DIR.getAbsolutePath() + "/_Lists");
//</editor-fold>

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final Map<String, File> PRUNELIST_MAP = new HashMap<>();

    //<editor-fold defaultstate="collapsed" desc="Extra Methods">
    private List<File> getPruneLists(File root) {
        List<File> prnlFiles = new ArrayList<>();
        /*
         @BUGFIX: V3.2.1
         If the received root doesn't exist in the file-system, or is not a directory, it can't have children.
         Return empty 'prnlFiles'.
         */
        if (!root.exists() || !root.isDirectory()) {
            return prnlFiles;
        }
        for (File file : root.listFiles()) {
            if (file.isDirectory()) {
                prnlFiles.addAll(getPruneLists(file));
            } else {
                if (file.getName().toLowerCase().endsWith(".prnl")) {
                    prnlFiles.add(file);
                }
            }
        }
        return prnlFiles;
    }

    private List<DefaultMutableTreeNode> parsePruneList(File file) throws FileNotFoundException, IOException {
        List<DefaultMutableTreeNode> nodeList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                nodeList.add(getTreeNodeFromFilePath(line));
            }
        }
        return nodeList;
    }

    @SuppressWarnings("null")
    private DefaultMutableTreeNode getTreeNodeFromFilePath(String path) {
        DefaultMutableTreeNode node = null;
        for (String split : path.split("(\\\\)|/")) {
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(split);
            if (node != null) {
                node.add(newNode);
            }
            node = newNode;
        }
//        return (DefaultMutableTreeNode) node.getRoot();
        return node;
    }
//</editor-fold>

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
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

        jScrollPane_MainPanel = new javax.swing.JScrollPane();
        jPanel_MainPanel = new javax.swing.JPanel();
        jPanel_LeftPanel = new javax.swing.JPanel();
        jPanel_EnabledTreePanel = new javax.swing.JPanel();
        jScrollPane_EnabledTree = new javax.swing.JScrollPane();
        jTree_EnabledTree = new javax.swing.JTree();
        jPanel_CenterPanel = new javax.swing.JPanel();
        jPanel_DirectControlsPanel = new javax.swing.JPanel();
        jButton_DisableSelectedNode = new javax.swing.JButton();
        jButton_EnableSelectedNode = new javax.swing.JButton();
        jPanel_ListPanel = new javax.swing.JPanel();
        jPanel_ListManagementPanel = new javax.swing.JPanel();
        jComboBox_ListSelector = new javax.swing.JComboBox();
        jPanel_ListManagementControlsPanel = new javax.swing.JPanel();
        jButton_SaveList = new javax.swing.JButton();
        jButton_DeleteList = new javax.swing.JButton();
        jPanel_ListTreePanel = new javax.swing.JPanel();
        jScrollPane_ListTree = new javax.swing.JScrollPane();
        jTree_ListTree = new javax.swing.JTree();
        jPanel_ListControlsPanel = new javax.swing.JPanel();
        jPanel_ListNodeControlsPanel = new javax.swing.JPanel();
        jPanel_ListSpecificNodeControlsPanel = new javax.swing.JPanel();
        jButton_EnableSelectedListedNodes = new javax.swing.JButton();
        jButton_AddSelectedEnabledNodesToList = new javax.swing.JButton();
        jButton_AddSelectedDisabledNodesToList = new javax.swing.JButton();
        jButton_DisableSelectedListedNodes = new javax.swing.JButton();
        jPanel_ListGeneralNodeControlspanel = new javax.swing.JPanel();
        jButton_EnableAllListedNodes = new javax.swing.JButton();
        jButton_DisableAllListedNodes = new javax.swing.JButton();
        jPanel_RightPanel = new javax.swing.JPanel();
        jPanel_DisabledTreePanel = new javax.swing.JPanel();
        jScrollPane_DisabledTree = new javax.swing.JScrollPane();
        jTree_DisabledTree = new javax.swing.JTree();
        jPanel_ConsolidationControls = new javax.swing.JPanel();
        jButton_Apply = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KSP AutoPruner GUI");
        getContentPane().setLayout(new java.awt.CardLayout());

        jScrollPane_MainPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel_MainPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel_MainPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel_MainPanel.setLayout(new java.awt.GridBagLayout());

        jPanel_LeftPanel.setLayout(new java.awt.GridBagLayout());

        jPanel_EnabledTreePanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createTitledBorder("Enabled Files:")));
        jPanel_EnabledTreePanel.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel_EnabledTreePanel.setLayout(new java.awt.GridBagLayout());

        jTree_EnabledTree.setModel(new PathAwareUndoableTreeModel(Util.getNodeFromFile(gameDataDir)));
        jTree_EnabledTree.setMaximumSize(new java.awt.Dimension(0, 0));
        jTree_EnabledTree.setName(""); // NOI18N
        jTree_EnabledTree.setPreferredSize(new java.awt.Dimension(0, 0));
        jTree_EnabledTree.setRootVisible(false);
        jScrollPane_EnabledTree.setViewportView(jTree_EnabledTree);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_EnabledTreePanel.add(jScrollPane_EnabledTree, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_LeftPanel.add(jPanel_EnabledTreePanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_MainPanel.add(jPanel_LeftPanel, gridBagConstraints);

        jPanel_CenterPanel.setPreferredSize(new java.awt.Dimension(96, 95));
        jPanel_CenterPanel.setLayout(new java.awt.GridBagLayout());

        jPanel_DirectControlsPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createTitledBorder("Direct Controls:")));
        jPanel_DirectControlsPanel.setLayout(new java.awt.GridBagLayout());

        jButton_DisableSelectedNode.setText(">>>>>");
        jButton_DisableSelectedNode.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton_DisableSelectedNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DisableSelectedNodeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_DirectControlsPanel.add(jButton_DisableSelectedNode, gridBagConstraints);

        jButton_EnableSelectedNode.setText("<<<<<");
        jButton_EnableSelectedNode.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton_EnableSelectedNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EnableSelectedNodeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_DirectControlsPanel.add(jButton_EnableSelectedNode, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel_CenterPanel.add(jPanel_DirectControlsPanel, gridBagConstraints);

        jPanel_ListPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createTitledBorder("List Controls:")));
        jPanel_ListPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel_ListPanel.setLayout(new java.awt.GridBagLayout());

        jPanel_ListManagementPanel.setLayout(new java.awt.GridLayout(1, 2));

        jComboBox_ListSelector.setModel(new DefaultComboBoxModel());
        /*
        -Retrieve and filter the prunelists from the file-system.
        -Map prunelists' names to their files.
        -Add prunelists' names to the lists' combobox.
        */
        for (File file : getPruneLists(pruneListsDir)) {
            String fileName = file.getName();
            PRUNELIST_MAP.put(fileName, file);
            jComboBox_ListSelector.addItem(fileName);
        }
        jComboBox_ListSelector.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_ListSelectorItemStateChanged(evt);
            }
        });
        jPanel_ListManagementPanel.add(jComboBox_ListSelector);

        jPanel_ListManagementControlsPanel.setLayout(new java.awt.GridLayout(0, 2));

        jButton_SaveList.setText("Save");
        jButton_SaveList.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jPanel_ListManagementControlsPanel.add(jButton_SaveList);

        jButton_DeleteList.setText("Delete");
        jButton_DeleteList.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jPanel_ListManagementControlsPanel.add(jButton_DeleteList);

        jPanel_ListManagementPanel.add(jPanel_ListManagementControlsPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel_ListPanel.add(jPanel_ListManagementPanel, gridBagConstraints);

        jPanel_ListTreePanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createTitledBorder("List Files:")));
        jPanel_ListTreePanel.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel_ListTreePanel.setLayout(new java.awt.GridBagLayout());

        jTree_ListTree.setModel(new PathAwareUndoableTreeModel(new DefaultMutableTreeNode("ListRoot")));
        jTree_ListTree.setMaximumSize(new java.awt.Dimension(0, 0));
        jTree_ListTree.setPreferredSize(new java.awt.Dimension(0, 0));
        jTree_ListTree.setRootVisible(false);
        jScrollPane_ListTree.setViewportView(jTree_ListTree);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_ListTreePanel.add(jScrollPane_ListTree, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_ListPanel.add(jPanel_ListTreePanel, gridBagConstraints);

        jPanel_ListControlsPanel.setLayout(new java.awt.GridBagLayout());

        jPanel_ListNodeControlsPanel.setLayout(new java.awt.GridBagLayout());

        jPanel_ListSpecificNodeControlsPanel.setLayout(new java.awt.GridBagLayout());

        jButton_EnableSelectedListedNodes.setText("<<<");
        jButton_EnableSelectedListedNodes.setMargin(new java.awt.Insets(2, 2, 2, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.6;
        jPanel_ListSpecificNodeControlsPanel.add(jButton_EnableSelectedListedNodes, gridBagConstraints);

        jButton_AddSelectedEnabledNodesToList.setText(">");
        jButton_AddSelectedEnabledNodesToList.setMargin(new java.awt.Insets(2, 2, 2, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        jPanel_ListSpecificNodeControlsPanel.add(jButton_AddSelectedEnabledNodesToList, gridBagConstraints);

        jButton_AddSelectedDisabledNodesToList.setText("<");
        jButton_AddSelectedDisabledNodesToList.setMargin(new java.awt.Insets(2, 2, 2, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        jPanel_ListSpecificNodeControlsPanel.add(jButton_AddSelectedDisabledNodesToList, gridBagConstraints);

        jButton_DisableSelectedListedNodes.setText(">>>");
        jButton_DisableSelectedListedNodes.setMargin(new java.awt.Insets(2, 2, 2, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.6;
        jPanel_ListSpecificNodeControlsPanel.add(jButton_DisableSelectedListedNodes, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel_ListNodeControlsPanel.add(jPanel_ListSpecificNodeControlsPanel, gridBagConstraints);

        jPanel_ListGeneralNodeControlspanel.setLayout(new java.awt.GridLayout(1, 2));

        jButton_EnableAllListedNodes.setText("Enable All");
        jButton_EnableAllListedNodes.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jPanel_ListGeneralNodeControlspanel.add(jButton_EnableAllListedNodes);

        jButton_DisableAllListedNodes.setText("Disable All");
        jButton_DisableAllListedNodes.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jPanel_ListGeneralNodeControlspanel.add(jButton_DisableAllListedNodes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel_ListNodeControlsPanel.add(jPanel_ListGeneralNodeControlspanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel_ListControlsPanel.add(jPanel_ListNodeControlsPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel_ListPanel.add(jPanel_ListControlsPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_CenterPanel.add(jPanel_ListPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_MainPanel.add(jPanel_CenterPanel, gridBagConstraints);

        jPanel_RightPanel.setLayout(new java.awt.GridBagLayout());

        jPanel_DisabledTreePanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createTitledBorder("Disabled Files:")));
        jPanel_DisabledTreePanel.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel_DisabledTreePanel.setLayout(new java.awt.GridBagLayout());

        jTree_DisabledTree.setModel(new PathAwareUndoableTreeModel(Util.getNodeFromFile(disabledFilesDir)));
        jTree_DisabledTree.setMaximumSize(new java.awt.Dimension(0, 0));
        jTree_DisabledTree.setPreferredSize(new java.awt.Dimension(0, 0));
        jTree_DisabledTree.setRootVisible(false);
        jScrollPane_DisabledTree.setViewportView(jTree_DisabledTree);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_DisabledTreePanel.add(jScrollPane_DisabledTree, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_RightPanel.add(jPanel_DisabledTreePanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel_MainPanel.add(jPanel_RightPanel, gridBagConstraints);

        jPanel_ConsolidationControls.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createTitledBorder("Consolidation Controls:")));
        jPanel_ConsolidationControls.setLayout(new java.awt.GridLayout(1, 2));

        jButton_Apply.setText("Apply");
        jButton_Apply.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jPanel_ConsolidationControls.add(jButton_Apply);

        jButton_Cancel.setText("Cancel");
        jButton_Cancel.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jPanel_ConsolidationControls.add(jButton_Cancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel_MainPanel.add(jPanel_ConsolidationControls, gridBagConstraints);

        jScrollPane_MainPanel.setViewportView(jPanel_MainPanel);

        getContentPane().add(jScrollPane_MainPanel, "card2");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_EnableSelectedNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnableSelectedNodeActionPerformed
        //If nothing selected, do nothing.
        if (jTree_DisabledTree.getSelectionCount() == 0) {
            return;
        }

        PathAwareUndoableTreeModel catchingModel = (PathAwareUndoableTreeModel) jTree_EnabledTree.getModel();
        PathAwareUndoableTreeModel releassingModel = (PathAwareUndoableTreeModel) jTree_DisabledTree.getModel();
        for (TreePath path : jTree_DisabledTree.getSelectionPaths()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            DefaultMutableTreeNode newNode = (DefaultMutableTreeNode) node.clone();

            //Insert a clone of this node into the catching tree.
            catchingModel.insertNodeInto(newNode, catchingModel.getInsertionNode(node));
            if (!node.isLeaf()) {
                //Insert all leafs descendant fom this node into the catching tree.
                Enumeration depthFirstEnumeration = node.depthFirstEnumeration();
                while (depthFirstEnumeration.hasMoreElements()) {
                    DefaultMutableTreeNode e = (DefaultMutableTreeNode) depthFirstEnumeration.nextElement();
                    if (e.isLeaf()) {
                        catchingModel.insertNodeInto((MutableTreeNode) e.clone(), catchingModel.getInsertionNode(e));
                    }
                }
            }
            //Add newNode to the selection in the catching tree.
            jTree_EnabledTree.addSelectionPath(new TreePath(newNode.getPath()));
            //Remove node from the original tree.
            releassingModel.removeNodeFromParent(node);
        }
    }//GEN-LAST:event_jButton_EnableSelectedNodeActionPerformed

    private void jButton_DisableSelectedNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DisableSelectedNodeActionPerformed
        //If nothing selected, do nothing.
        if (jTree_EnabledTree.getSelectionCount() == 0) {
            return;
        }

        PathAwareUndoableTreeModel catchingModel = (PathAwareUndoableTreeModel) jTree_DisabledTree.getModel();
        PathAwareUndoableTreeModel releassingModel = (PathAwareUndoableTreeModel) jTree_EnabledTree.getModel();
        for (TreePath path : jTree_EnabledTree.getSelectionPaths()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            DefaultMutableTreeNode newNode = (DefaultMutableTreeNode) node.clone();

            //Insert a clone of this node into the catching tree.
            catchingModel.insertNodeInto(newNode, catchingModel.getInsertionNode(node));
            if (!node.isLeaf()) {
                //Insert all leafs descendant fom this node into the catching tree.
                Enumeration depthFirstEnumeration = node.depthFirstEnumeration();
                while (depthFirstEnumeration.hasMoreElements()) {
                    DefaultMutableTreeNode e = (DefaultMutableTreeNode) depthFirstEnumeration.nextElement();
                    if (e.isLeaf()) {
                        catchingModel.insertNodeInto((MutableTreeNode) e.clone(), catchingModel.getInsertionNode(e));
                    }
                }
            }
            //Add newNode to the selection in the catching tree.
            jTree_DisabledTree.addSelectionPath(new TreePath(newNode.getPath()));
            //Remove node from the original tree.
            releassingModel.removeNodeFromParent(node);
        }
    }//GEN-LAST:event_jButton_DisableSelectedNodeActionPerformed

    private void jComboBox_ListSelectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_ListSelectorItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            //Clear tree of previous prunelist's nodes.
            PathAwareUndoableTreeModel model = (PathAwareUndoableTreeModel) jTree_ListTree.getModel();
            ((DefaultMutableTreeNode) model.getRoot()).removeAllChildren();
            model.reload();

            //Repopulate tree with new prunelist's nodes.
            String item = (String) evt.getItem();
            try {
                List<DefaultMutableTreeNode> parsedNodes = parsePruneList(PRUNELIST_MAP.get(item));
                for (DefaultMutableTreeNode node : parsedNodes) {
                    new DefaultMutableTreeNode("Generic Parent").add((MutableTreeNode) node.getRoot());

                    model.insertNode(node);
                    System.out.println("TEST: " + Arrays.toString(node.getPath()));
                    jTree_ListTree.addSelectionPath(new TreePath(node.getPath()));
                }
            } catch (IOException ex) {
                //@TODO: Display warning popup stating the file couldn't be read.
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_ListSelectorItemStateChanged

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
    private javax.swing.JButton jButton_AddSelectedDisabledNodesToList;
    private javax.swing.JButton jButton_AddSelectedEnabledNodesToList;
    private javax.swing.JButton jButton_Apply;
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_DeleteList;
    private javax.swing.JButton jButton_DisableAllListedNodes;
    private javax.swing.JButton jButton_DisableSelectedListedNodes;
    private javax.swing.JButton jButton_DisableSelectedNode;
    private javax.swing.JButton jButton_EnableAllListedNodes;
    private javax.swing.JButton jButton_EnableSelectedListedNodes;
    private javax.swing.JButton jButton_EnableSelectedNode;
    private javax.swing.JButton jButton_SaveList;
    private javax.swing.JComboBox jComboBox_ListSelector;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel_CenterPanel;
    private javax.swing.JPanel jPanel_ConsolidationControls;
    private javax.swing.JPanel jPanel_DirectControlsPanel;
    private javax.swing.JPanel jPanel_DisabledTreePanel;
    private javax.swing.JPanel jPanel_EnabledTreePanel;
    private javax.swing.JPanel jPanel_LeftPanel;
    private javax.swing.JPanel jPanel_ListControlsPanel;
    private javax.swing.JPanel jPanel_ListGeneralNodeControlspanel;
    private javax.swing.JPanel jPanel_ListManagementControlsPanel;
    private javax.swing.JPanel jPanel_ListManagementPanel;
    private javax.swing.JPanel jPanel_ListNodeControlsPanel;
    private javax.swing.JPanel jPanel_ListPanel;
    private javax.swing.JPanel jPanel_ListSpecificNodeControlsPanel;
    private javax.swing.JPanel jPanel_ListTreePanel;
    private javax.swing.JPanel jPanel_MainPanel;
    private javax.swing.JPanel jPanel_RightPanel;
    private javax.swing.JScrollPane jScrollPane_DisabledTree;
    private javax.swing.JScrollPane jScrollPane_EnabledTree;
    private javax.swing.JScrollPane jScrollPane_ListTree;
    private javax.swing.JScrollPane jScrollPane_MainPanel;
    private javax.swing.JTree jTree_DisabledTree;
    private javax.swing.JTree jTree_EnabledTree;
    private javax.swing.JTree jTree_ListTree;
    // End of variables declaration//GEN-END:variables
}
