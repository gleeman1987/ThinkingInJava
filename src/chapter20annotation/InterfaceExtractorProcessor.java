package chapter20annotation;

import sun.reflect.annotation.AnnotationParser;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.beans.MethodDescriptor;
import java.util.ArrayList;
import java.util.Set;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/5
 * Mail:zhengjun1987@outlook.com
 */
public class InterfaceExtractorProcessor extends AbstractProcessor {
    private final RoundEnvironment annotationProcessorEnvironment;

    public InterfaceExtractorProcessor(RoundEnvironment annotationProcessorEnvironment) {
        this.annotationProcessorEnvironment = annotationProcessorEnvironment;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("InterfaceExtractorProcessor.process  " + "annotations = [" + annotations + "], roundEnv = [" + roundEnv + "]");
//        ArrayList<MethodDescriptor> typeDeclarations = new ArrayList<TypeDeclaration>();
        return false;
    }
}
