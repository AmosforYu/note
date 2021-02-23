package com.yyb.learn.jbasics.basic.algorithm.bst;


/**
 * @author Yamos
 * @description BinarySearchTree 二叉搜索树实现
 * @date 2021/2/22 0022 14:23
 */
public class BinarySearchTree<T extends Comparable<T>> {

    /**
     * 节点值
     **/
    private T nodeValue;

    /**
     * 左节点引用
     **/
    BinarySearchTree<T> left;

    /**
     * 右节点引用
     **/
    BinarySearchTree<T> right;

    /**
     * 根节点引用
     **/
    BinarySearchTree<T> root;

    /**
     * 父节点引用, 节点删除时会使用到
     **/
    BinarySearchTree<T> parent;

    /**
     * @param nodeValue 节点值
     */
    public BinarySearchTree(T nodeValue) {
        this.nodeValue = nodeValue;
    }

    public BinarySearchTree() {
    }

    public T getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(T nodeValue) {
        this.nodeValue = nodeValue;
    }

    @Override
    public String toString() {
        return nodeValue.toString();
    }

    /**
     * BST 查找(非递归实现)
     * 1.从根节点开始比较
     * 2.比当前节点小，再比较其左子树节点值；比当前节点大，再比较其右子树节点值
     * 3.与当前节点值相等，表示已找到并返回；或者查找完毕未找到
     *
     * @param searchValue
     * @return
     */
    public BinarySearchTree<T> searchTree(T searchValue) {
        if (null == root) {
            return null;
        }

        BinarySearchTree<T> searchNode = root;
        while (null != searchNode && searchValue != root.getNodeValue()) {
            if (searchValue.compareTo(searchNode.getNodeValue()) < 0) {
                searchNode = searchNode.left;
            } else {
                searchNode = searchNode.right;
            }
        }

        return searchNode;
    }

    /**
     * BST 查找(递归实现)
     *
     * @param root  根节点引用
     * @param searchValue   待查找的值
     * @return
     */
    public BinarySearchTree<T> searchTree(BinarySearchTree<T> root, T searchValue) {
        if (null == root) {
            return null;
        }

        if (searchValue.compareTo(root.getNodeValue()) < 0) {
            return searchTree(root.left, searchValue);
        } else if (searchValue.compareTo(root.getNodeValue()) > 0) {
            return searchTree(root.right, searchValue);
        } else {
            return root;
        }
    }

    /**
     * BST 插入(非递归实现)
     *
     * @param insertValue
     * @return
     */
    public boolean insertTree(T insertValue) {
        BinarySearchTree<T> insert = new BinarySearchTree(insertValue);
        if (null == root) {
            root = insert;
            return true;
        }

        BinarySearchTree<T> current = root;
        while (true) {
            parent = current;
            if (insertValue.compareTo(current.getNodeValue()) < 0) {
                current = current.left;
                if (null == current) {
                    parent.left = insert;
                    return true;
                }
            } else {
                current = current.right;
                if (null == current) {
                    parent.right = insert;
                    return true;
                }
            }
        }
    }

    /**
     * BST 插入(递归实现)
     *
     * @param root
     * @param insertValue
     * @return
     */
    public boolean insertTree(BinarySearchTree<T> root, T insertValue) {
        BinarySearchTree<T> insert = new BinarySearchTree(insertValue);
        if (null == root) {
            root = insert;
            return true;
        }

        if (insertValue.compareTo(root.getNodeValue()) < 0) {
            if (null == root.left) {
                root.left = insert;
                insert.parent = root;
                return true;
            } else {
                return insertTree(root.left, insertValue);
            }
        } else if (insertValue.compareTo(root.getNodeValue()) > 0) {
            if (null == root.right) {
                root.right = insert;
                insert.parent = root;
                return true;
            } else {
                return insertTree(root.right, insertValue);
            }
        } else {
            return false;
        }
    }

    /**
     * BST 移除(递归实现)
     * 1.查找到被删除节点
     * 2.被删除节点没有左右子树，直接删除；
     * 被删除节点只有左子树，寻找左子树中的最大值，
     * @param current
     * @param removeValue
     * @return
     */
    public boolean removeTree(BinarySearchTree<T> current, T removeValue) {

        /* 1.查找被删除数据的位置 */
        if (current.getNodeValue().compareTo(removeValue) > 0) {
            return removeTree(current.left, removeValue);
        }

        if (current.getNodeValue().compareTo(removeValue) < 0) {
            return removeTree(current.right, removeValue);
        }

        BinarySearchTree<T> parent = current.parent;
        BinarySearchTree<T> left = current.left;
        BinarySearchTree<T> right = current.right;
        if (null == left && null == right) { /* 2.被删除节点无子树 */
            if (parent.left == current) {
                parent.left = null;
            }

            if (parent.right == current) {
                parent.right = null;
            }
            return true;
        } else if (null != left && null == right) { /* 3.被删除节点只有左子树 */
            if (parent.left == current) {
                parent.left = left;
            }

            if (parent.right == current) {
                parent.right = left;
            }

            left.parent = parent;
            return true;
        } else if (null == left && null != right) { /* 4.被删除节点只有右子树 */
            if (parent.left == current) {
                parent.left = right;
            }

            if (parent.right == current) {
                parent.right = right;
            }

            right.parent = parent;
            return true;
        } else { /* 5.被删除节点有左、右子树 */
            BinarySearchTree<T> rightMax = right;
            while (null != rightMax) {
                rightMax = rightMax.right;
            }

            //移除 被删除节点的后继者
            rightMax.parent = null;
            //将后继者的节点值赋值给被删除节点
            current.nodeValue = rightMax.getNodeValue();
            return true;
        }
    }

}
