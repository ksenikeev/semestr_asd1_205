import java.io.FileWriter;
import java.io.IOException;

public class TreeSort {
    private static int count = 0;

    public static void main(String[] args) {
        int[] a;

        try (FileWriter writer = new FileWriter("tree.csv")) {

            for (int i = 100; i < 10000; i += 100) {
                a = new int[i];
                for (int j = 0; j < i; ++j) {
                    a[j] = (int) (Math.random() * i);
                }
                long t = System.nanoTime();
                count = 0;
                new Tree(a);
                writer.write(i + ";" + count + ";" + (System.nanoTime() - t) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Скомпилируйте и введите java TreeSort
    static class Tree {
        public Tree left;            // левое и правое поддеревья и ключ
        public Tree right;
        public int key;

        public Tree(int k) {        // конструктор с инициализацией ключа
            key = k;
        }

        public Tree(int[] a) {


        }

        /*  insert (добавление нового поддерева (ключа))
            сравнить ключ добавляемого поддерева (К) с ключом корневого узла (X).
            Если K>=X, рекурсивно добавить новое дерево в правое поддерево.
            Если K<X, рекурсивно добавить новое дерево в левое поддерево.
            Если поддерева нет, то вставить на это место новое дерево
        */
        public void insert( Tree aTree) {
            if ( aTree.key < key )
                if ( left != null ){
                    left.insert( aTree );
                }
                else {
                    left = aTree;
                }
            else
            if ( right != null ){
                right.insert( aTree );
            }
            else{
                right = aTree;
            }
        }

        /*  traverse (обход)
            Рекурсивно обойти левое поддерево.
            Применить функцию f (печать) к корневому узлу.
            Рекурсивно обойти правое поддерево.
        */
        public void traverse(TreeVisitor visitor) {
            if ( left != null)
                left.traverse( visitor );
            visitor.visit(this);

            if ( right != null )
                right.traverse( visitor );
        }
    }

    interface TreeVisitor {
        public void visit(Tree node);
    }

    class KeyPrinter  implements TreeVisitor {
        public void visit(Tree node) {
            System.out.println( " " + node.key );
        }
    }

}
