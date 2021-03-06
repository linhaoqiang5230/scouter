package scouter.bytebuddy.implementation.bytecode.constant;

import scouter.bytebuddy.implementation.Implementation;
import scouter.bytebuddy.implementation.bytecode.StackManipulation;
import scouter.bytebuddy.implementation.bytecode.StackSize;
import scouter.bytebuddy.jar.asm.MethodVisitor;
import scouter.bytebuddy.jar.asm.Opcodes;

/**
 * Represents a stack manipulation to load a {@code null} pointer onto the operand stack.
 */
public enum NullConstant implements StackManipulation {

    /**
     * The singleton instance.
     */
    INSTANCE(StackSize.SINGLE);

    /**
     * The size impact of loading the {@code null} reference onto the operand stack.
     */
    private final Size size;

    /**
     * Creates a null constant.
     *
     * @param size The size of the constant on the operand stack.
     */
    NullConstant(StackSize size) {
        this.size = size.toIncreasingSize();
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
        methodVisitor.visitInsn(Opcodes.ACONST_NULL);
        return size;
    }
}
