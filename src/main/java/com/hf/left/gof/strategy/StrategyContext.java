package com.hf.left.gof.strategy;

/**
 * @description:
 * 优点：
 * 简化代码：将算法的实现和使用分离，减少了代码的复杂性。
 * 扩展性好：可以方便地添加新的策略而不影响现有代码。
 * 复用性强：不同的策略可以被多个上下文复用，提高了代码的复用性。
 *
 * 缺点：
 * 增加类的数量：每个具体策略都需要定义一个类，可能会增加类的数量。
 * 客户端必须了解不同策略的实现：客户端需要知道不同策略的优缺点，以便选择合适的策略。
 * @author: huang fu
 * @date: 2024/6/3 15:00
 * @version: 1.0
 */
public class StrategyContext{

    private SortingStrategy sortingStrategy;

    public StrategyContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(int[] numbers){
        sortingStrategy.sort(numbers);
    }

    public static void main(String[] args) {



    }
}

class QuickSortStrategy implements SortingStrategy{

    @Override
    public void sort(int[] numbers) {

    }
}

class BubbleSortStrategy implements SortingStrategy{

    @Override
    public void sort(int[] numbers) {

    }
}





