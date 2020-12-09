package com.yyb.learn.jbasics.basic.Sets;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @description: 手写LinkedList
 * @author: Mr.Yu
 * @date: 2020-08-25 15:45
 **/
public class LinkedListCla<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, Serializable {

    /**
     * -链表节点个数,表示链表大小
     */
    transient int size = 0;

    /**
     * -链表头，指向链表第一个节点
     */
    transient Node<E> first;

    /**
     * -链表尾，指向链表最后一个节点
     */
    transient Node<E> last;

    @Override
    public ListIterator<E> listIterator(int index) {
        checkPositionIndex(index);
        return new ListItr(index);
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    /*============= 常用方法START =============*/
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    public boolean addAll (Collection<? extends E> c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        Object[] o = c.toArray();
        int length = o.length;
        if (0 == length)
            return false;

        //循环将元素一个个链接到链表上

        Node<E> prev,succ;
        if (index == size) {
            prev = last;
            succ = null;
        } else {
            succ = node(index);
            prev = succ.prev;
        }

        for (int i = 0; i < length; i++) {
            E e = (E) o[i];
            Node<E> newNode = new Node<>(e, prev, null);
            if (null == prev) {
                first = newNode;
            } else {
                prev.next = newNode;
            }
            prev = newNode;
        }

        if (null == succ) {
            last = prev;
        } else {
            prev.next = succ;
            succ.prev = prev;
        }

        size+=length;
        modCount++;

        return true;
    }

    /**
     * -获取链表第一个节点的数据
     * -链表大小为0或为空时，抛出异常NoSuchElementException
     * @return
     */
    @Override
    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    /**
     * -获取链表最后一个节点的数据
     * -链表大小为0或为空时，抛出异常NoSuchElementException
     * @return
     */
    @Override
    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    /**
     * -增加节点到首位
     * @param e
     */
    @Override
    public void addFirst(E e) {
        linkFirst(e);
    }

    /**
     * -增加节点到末位
     * @param e
     */
    @Override
    public void addLast(E e) {
        linkLast(e);
    }

    public int lastIndexOf(Object o) {
        int lastIndex = size - 1;
        E e = (E) o;

        for (Node<E> x = last; x != null; x = x.prev) {
            if (e == x.item)
                return lastIndex;
            lastIndex--;
        }

        return -1;
        /*源代码  Object.equals(Object obj) ---> this == obj
        int index = size;
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (x.item == null)
                    return index;
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (o.equals(x.item))
                    return index;
            }
        }
        return -1;
        */
    }


    //其他方法...
    /*============= 常用方法END =============*/



    /**
     * -inner call {@method addFirst(E e)}
     * @param e
     * @return true
     */
    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    /**
     * -inner call {@method addLast(E e)}
     * @param e
     * @return true
     */
    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    /**
     * -inner call {@method unlinkFirst(Node<E> f)}
     * -链表大小为0或为空时，抛出异常NoSuchElementException
     * @return E
     */
    @Override
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    /**
     * -inner call {@method unlinkLast(Node<E> f)}
     * -链表大小为0或为空时，抛出异常NoSuchElementException
     * @return E
     */
    @Override
    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    /**
     * -inner call {@method unlinkFirst(Node<E> f)}
     * -链表大小为0或为空时，返回null
     * @return E
     */
    @Override
    public E pollFirst() {
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }

    /**
     * -inner call {@method unlinkLast(Node<E> l)}
     * -链表大小为0或为空时，返回null
     * @return E
     */
    @Override
    public E pollLast() {
        final Node<E> l = last;
        return (l == null) ? null : unlinkLast(l);
    }



    /**
     * -获取链表第一个节点的数据
     * -链表大小为0或为空时，返回null
     * @return
     */
    @Override
    public E peekFirst() {
        final Node<E> f = first;
        return (f == null) ? null : f.item;
    }

    /**
     * -获取链表最后一个节点的数据
     * -链表大小为0或为空时，返回null
     * @return
     */
    @Override
    public E peekLast() {
        final Node<E> l = last;
        return (l == null) ? null : l.item;
    }

    /**
     * -从前往后比较，删除存储该数据{@code o}的节点
     * @param o
     * @return boolean
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * -从后往前比较，删除存储该数据{@code o}的节点
     * @param o
     * @return boolean
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (null == x.item) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (o == x.item) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean offer(E e) {
        return add(e);
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E poll() {
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E peek() {
        final Node<E> f = first;
        return (f == null) ? null : f.item;
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new DescendingIterator();
    }

    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    /**
     * 移除该节点，并返回该节点元素
     * @param node
     * @return
     */
    private E unlink(Node<E> node) {
        final E element = node.item;
        final Node<E> prev = node.prev;
        final Node<E> next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;
        modCount++;
        return element;
    }

    private E unlinkFirst(Node<E> f) {
//        final E element = f.item;
//        final Node<E> next = f.next;
//        if (next == null)
//            f = null;
//        else
//            first = next;
//        size--;
//        modCount++;
//        return element;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null; //——清除当前结点数据
        f.next = null; // help GC ——清除当前节点对下一节点的指向
        first = next;  //——将当前节点的下一节点置为第一节点
        if (next == null)//——下一节点为null表明当前链表只有一个节点，将last置为null
            last = null;
        else
            next.prev = null;//——链表不止一个节点，将下一个节点对第一个节点的指向清除
        size--;
        modCount++;
        return element;
    }

    private E unlinkLast(Node<E> l) {
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }


    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<E>(e,null, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;

        size++;
        modCount++;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e, l, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;

        size++;
        modCount++;
    }

    private void linkBefore(E e, Node<E> node) {
        final Node<E> prev = node.prev;
        final Node newNode = new Node(e, prev, node);
        if (prev == null)
            first = newNode;
        else
            prev.next = newNode;

        size++;
        modCount++;
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private class DescendingIterator implements Iterator<E> {
        private final ListItr itr = new ListItr(size());
        public boolean hasNext() {
            return itr.hasPrevious();
        }
        public E next() {
            return itr.previous();
        }
        public void remove() {
            itr.remove();
        }
    }

    private class ListItr implements ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;
        private int expectedModCount = modCount;

        ListItr(int index) {
            // assert isPositionIndex(index);
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            checkForComodification();
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }


        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public E previous() {
            checkForComodification();
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.item;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {
            checkForComodification();
            if (lastReturned == null)
                throw new IllegalStateException();

            Node<E> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
            expectedModCount++;
        }

        public void set(E e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            checkForComodification();
            lastReturned.item = e;
        }

        public void add(E e) {
            checkForComodification();
            lastReturned = null;
            if (next == null)
                linkLast(e);
            else
                linkBefore(e, next);
            nextIndex++;
            expectedModCount++;
        }

        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            while (modCount == expectedModCount && nextIndex < size) {
                action.accept(next.item);
                lastReturned = next;
                next = next.next;
                nextIndex++;
            }
            checkForComodification();
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}
