package me.xtrm.gradle.postprocessor.test;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class TestPostProcessorPlugin implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        target.getPlugins().apply("me.xtrm.postprocessor.root");
    }
}
