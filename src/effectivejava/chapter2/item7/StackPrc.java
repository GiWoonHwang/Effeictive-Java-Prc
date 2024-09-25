package effectivejava.chapter2.item7;

import java.util.Arrays;


public class StackPrc {
    private Object[] elements;

    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackPrc() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public  void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 스택에서 요소를 제거할 때, size(저장된 요소의 개수)를 감소시키기만 하고 해당 배열의 인덱스를 null로 초기화 하지 않는다. 따라서 해당 위치에 요소가 남아있고 객체에 대한 참조가 유지된다.
    // 참조가 유지되면 메모리에서 해제되지 않고 결과적으로 메모리 누수가 발생된다.
    public Object pop() {
        if (size == 0)
                throw new EmptyStackException();
        return elements[--size];
    }


    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }



}
