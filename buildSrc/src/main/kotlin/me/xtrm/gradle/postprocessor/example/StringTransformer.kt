package me.xtrm.gradle.postprocessor.example

import me.xtrm.gradle.postprocessor.api.Transformer
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.LdcInsnNode

class StringTransformer: Transformer(
    "me/xtrm/postprocessor/example/"
) {
    override fun transform(classNode: ClassNode) {
        classNode.methods.flatMap { it.instructions.toList() }.filterIsInstance<LdcInsnNode>().filter {
            it.cst is String
        }.forEach {
            it.cst = (it.cst as String).replace("John", "Gary")
        }
    }
}
