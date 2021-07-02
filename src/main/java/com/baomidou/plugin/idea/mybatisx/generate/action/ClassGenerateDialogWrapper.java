package com.baomidou.plugin.idea.mybatisx.generate.action;

import com.baomidou.plugin.idea.mybatisx.generate.dto.DefaultGenerateConfig;
import com.baomidou.plugin.idea.mybatisx.generate.dto.GenerateConfig;
import com.baomidou.plugin.idea.mybatisx.generate.dto.TemplateContext;
import com.baomidou.plugin.idea.mybatisx.generate.dto.TemplateSettingDTO;
import com.baomidou.plugin.idea.mybatisx.generate.setting.TemplatesSettings;
import com.baomidou.plugin.idea.mybatisx.generate.ui.CodeGenerateUI;
import com.baomidou.plugin.idea.mybatisx.generate.ui.TablePreviewUI;
import com.intellij.database.psi.DbTable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassGenerateDialogWrapper extends DialogWrapper {

    private static final Logger logger = LoggerFactory.getLogger(ClassGenerateDialogWrapper.class);

    private CodeGenerateUI codeGenerateUI = new CodeGenerateUI();

    private TablePreviewUI tablePreviewUI = new TablePreviewUI();

    private JPanel rootPanel = new JPanel();

    private java.util.List<JPanel> containerPanelList;

    private Action previousAction;

    private int page = 0;
    private int lastPage = 1;

    protected ClassGenerateDialogWrapper(@Nullable Project project) {
        super(project);
        this.setTitle("Generate Options");
        setOKButtonText("Next");
        setCancelButtonText("Cancel");

        previousAction = new DialogWrapperAction("Previous") {
            @Override
            protected void doAction(ActionEvent e) {
                page = page - 1;
                switchPage(page);
                previousAction.setEnabled(false);
                setOKButtonText("Next");
            }
        };
        // 默认禁用 上一个设置
        previousAction.setEnabled(false);
        // 初始化容器列表
        java.util.List<JPanel> list = new ArrayList<>();
        list.add(tablePreviewUI.getRootPanel());
        list.add(codeGenerateUI.getRootPanel());
        containerPanelList = list;
        // 默认切换到第一页
        switchPage(0);

        super.init();
    }

    @Override
    protected void doOKAction() {
        if (page == lastPage) {
            super.doOKAction();
            return;
        }
        page = page + 1;
        setOKButtonText("Finish");

        previousAction.setEnabled(true);
        switchPage(page);
    }

    private void switchPage(int newPage) {
        rootPanel.removeAll();
        rootPanel.add(containerPanelList.get(newPage));
        rootPanel.repaint();//刷新页面，重绘面板
        rootPanel.validate();//使重绘的面板确认生效
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return rootPanel;
    }

    @Override
    protected Action[] createActions() {
        return new Action[]{previousAction, getOKAction(), getCancelAction()};
    }


    public void fillData(Project project, List<DbTable> tableElements) {
        TemplatesSettings templatesSettings = TemplatesSettings.getInstance(project);
        final TemplateContext templateContext = templatesSettings.getTemplateConfigs();
        GenerateConfig generateConfig = templateContext.getGenerateConfig();
        if (generateConfig == null) {
            generateConfig = new DefaultGenerateConfig(templateContext);
        }

        final Map<String, List<TemplateSettingDTO>> settingMap = templatesSettings.getTemplateSettingMap();
        if (settingMap.isEmpty()) {
            throw new RuntimeException("无法获取模板");
        }

        tablePreviewUI.fillData(project,tableElements, generateConfig);
        codeGenerateUI.fillData(project,
            generateConfig,
            templateContext.getTemplateName(),
            settingMap);


    }

    public GenerateConfig determineGenerateConfig() {
        GenerateConfig generateConfig = new GenerateConfig();
        codeGenerateUI.refreshGenerateConfig(generateConfig);
        tablePreviewUI.refreshGenerateConfig(generateConfig);
        return generateConfig;
    }



}
