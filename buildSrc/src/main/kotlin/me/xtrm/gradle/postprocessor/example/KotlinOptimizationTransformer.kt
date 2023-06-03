package me.xtrm.gradle.postprocessor.example

import me.xtrm.gradle.postprocessor.api.Transformer
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodInsnNode

class KotlinOptimizationTransformer : Transformer {
    override fun transform(classNodes: MutableMap<String, ClassNode>) {
        classNodes.values.map {
            it.visibleAnnotations?.removeIf { annotation ->
                annotation.desc == "Lkotlin/Metadata;"
            }
            it
        }.flatMap { it.methods }.forEach { method ->
            method.instructions?.iterator()?.forEach { insn ->
                if (insn.opcode == Opcodes.INVOKESTATIC) { // can be done with compiler args sooooo
                    val node = insn as MethodInsnNode
                    if (node.owner == "kotlin/jvm/internal/Intrinsics" && node.name == "checkNotNullParameter") {
                        method.instructions.remove(node.previous.previous)
                        method.instructions.remove(node.previous)
                        method.instructions.remove(node)
                    }
                }
            }
        }
    }
}
