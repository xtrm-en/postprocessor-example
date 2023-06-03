package me.xtrm.gradle.postprocessor.test

import me.xtrm.gradle.postprocessor.api.Transformer
import org.objectweb.asm.tree.ClassNode

class TestTransformer : Transformer {
    override fun transform(classNodes: MutableMap<String, ClassNode>) {
        println("Hello from TestTransformer!")
    }
}
