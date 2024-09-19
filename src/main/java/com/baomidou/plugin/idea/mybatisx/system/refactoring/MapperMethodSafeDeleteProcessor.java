package com.baomidou.plugin.idea.mybatisx.system.refactoring;

import com.baomidou.plugin.idea.mybatisx.util.MapperUtils;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.xml.XmlTag;
import com.intellij.refactoring.safeDelete.NonCodeUsageSearchInfo;
import com.intellij.refactoring.safeDelete.SafeDeleteProcessorDelegateBase;
import com.intellij.usageView.UsageInfo;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

/**
 * @author : liushang@zsyjr.com
 * @date : 2021/8/11
 */
public class MapperMethodSafeDeleteProcessor extends SafeDeleteProcessorDelegateBase {


    @Override
    public boolean handlesElement(PsiElement element) {
        // 只处理方法重命名就好了
        if (!(element instanceof PsiMethod)) {
            return false;
        }
        PsiMethod psiMethod = (PsiMethod) element;
        final PsiClass containingClass = psiMethod.getContainingClass();
        if (containingClass == null) {
            return false;
        }
        final XmlTag tag = MapperUtils.findTag(containingClass.getProject(), psiMethod);
        return tag != null;
    }


    @Override
    public void prepareForDeletion(PsiElement element) throws IncorrectOperationException {
        PsiMethod psiMethod = (PsiMethod) element;
        final XmlTag tag = MapperUtils.findTag(psiMethod.getProject(), psiMethod);
        if (tag != null) {
            tag.delete();
        }
    }

    @Override
    public @Nullable NonCodeUsageSearchInfo findUsages(@NotNull PsiElement psiElement, PsiElement @NotNull [] psiElements, @NotNull List<? super UsageInfo> list) {
        return null;
    }

    @Override
    public @Nullable Collection<PsiElement> getAdditionalElementsToDelete(@NotNull PsiElement psiElement, @NotNull Collection<? extends PsiElement> collection, boolean b) {
        return null;
    }

    @Override
    public @Nullable
    Collection<String> findConflicts(@NotNull PsiElement element, @NotNull PsiElement[] allElementsToDelete) {
        return null;
    }

    @Override
    public @Nullable
    UsageInfo[] preprocessUsages(Project project, UsageInfo[] usages) {
        return usages;
    }


    @Override
    public boolean isToSearchInComments(PsiElement element) {
        return false;
    }

    @Override
    public void setToSearchInComments(PsiElement element, boolean enabled) {

    }

    @Override
    public boolean isToSearchForTextOccurrences(PsiElement element) {
        return false;
    }

    @Override
    public void setToSearchForTextOccurrences(PsiElement element, boolean enabled) {

    }

    @Override
    public @Nullable Collection<? extends PsiElement> getElementsToSearch(@NotNull PsiElement psiElement, @Nullable Module module, @NotNull Collection<? extends PsiElement> collection) {
        return null;
    }

}
