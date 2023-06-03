package me.xtrm.gradle.postprocessor.example

import me.xtrm.gradle.postprocessor.api.Transformer
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.LdcInsnNode

class StringTransformer : Transformer {
    override fun transform(classNodes: MutableMap<String, ClassNode>) {
        classNodes.values.flatMap { it.methods }
            .flatMap { it.instructions.toList() }
            .filterIsInstance<LdcInsnNode>()
            .filter {
                it.cst is String
            }.forEach {
                it.cst = (it.cst as String).replace("John", "Gary")
            }
    }
}
