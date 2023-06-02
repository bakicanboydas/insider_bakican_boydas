package utils.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotation {
    /*@Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod){
        Class<? extends IRetryAnalyzer> retry = annotation.getRetryAnalyzerClass();
        if(retry == null){
            annotation.setRetryAnalyzer((Class<? extends IRetryAnalyzer>) Retry.class);
        }
    }*/
}
