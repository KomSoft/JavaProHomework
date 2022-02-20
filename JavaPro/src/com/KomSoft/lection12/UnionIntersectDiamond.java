package com.KomSoft.lection12;

import java.util.*;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    5. Напишите методы union(Set<?>... set) и intersect(Set<?> ... set), реализующих операции
    объединения и пересечения множеств. Протестируйте работу этих методов на предварительно заполненных множествах.
*/
//public class  UnionIntersectDiamond <? extends Set>{
public class  UnionIntersectDiamond <T extends Set>{

//    public LinkedHashSet union(Set... inSets) {
//    public <S extends Set>  union(S mainSet, S... otherSets) {
//    public Set union(Set mainSet, Set... otherSets) {
//    public <S extends Set> Collection union(S mainSet, S... otherSets) {
//    public <S extends Set> UnionIntrsectDiamond<S> union(S... inSets) {
    public <T extends Set>UnionIntersectDiamond<T> union(Set... sets) {
        if(sets.length == 0) {
            return null;
        }
//        T newSet = new <T> for (Object o : (sets[0]))
//        T newSet = new T.getClass();

 /*       boolean res = true;
        Set newSet;
        if(mainSet.getClass().getName().contains("TreeSet")) {
             newSet = new TreeSet(mainSet);
        } else {
            if(mainSet.getClass().getName().contains("HashSet")) {
                newSet = new HashSet(mainSet);
            } else {
                newSet = new LinkedHashSet(mainSet);   // по умолчанию пусть будет Linked (не сортированый, но упорядоченый)
            }
        }
        for(Set<S> set : otherSets) {
            res = res & newSet.addAll(set);
        }
*/
        return null;
    }

/*
    // по умолчанию пусть будет Linked (не сортированый, но упорядоченый)
    public LinkedHashSet intersect(Set... inSets) {
        if(inSets.length == 0 ) {
            return null;
        }
        boolean res = true;
        LinkedHashSet newSet = new LinkedHashSet(inSets[0]);
        for(int i = 1; i < inSets.length; i++) {
            res = res & newSet.retainAll(inSets[i]);
        }
        return newSet;
    }
*/


    public static void main(String[] args) {
        UnionIntersectDiamond<Set> uis = new UnionIntersectDiamond<>();
        Set<String> hashSet1 = new HashSet<>(10, 0.8f);
        LinkedHashSet<String> linkedHashSet1 = new LinkedHashSet<>(10, 0.8f);
        LinkedHashSet<String> linkedHashSet2 = new LinkedHashSet<>(10, 0.8f);
        LinkedHashSet<String> linkedHashSet3 = new LinkedHashSet<>(10, 0.8f);
        Set<String> treeSet1 = new TreeSet<>();
        // initializing hashSet1
        hashSet1.add("one");
        hashSet1.add("two");
        hashSet1.add("ten");
        hashSet1.add("eleven");
        hashSet1.add("twelve");
        hashSet1.add("eight");
        hashSet1.add("three");
        hashSet1.add("zero");
        // initializing linkedHashSet2
        linkedHashSet1.add("eleven");
        linkedHashSet1.add("four");
        linkedHashSet1.add("fifth");
        linkedHashSet1.add("five");
        linkedHashSet1.add("ten");
        linkedHashSet1.add("six");
        linkedHashSet1.add("zero");
        linkedHashSet1.add("seven");
        // initializing linkedHashSet2
        linkedHashSet2.add("ten");
        linkedHashSet2.add("nine");
        linkedHashSet2.add("eight");
        linkedHashSet2.add("seven");
        linkedHashSet2.add("six");
        linkedHashSet2.add("five");
        linkedHashSet2.add("four");
        // initializing linkedHashSet3
        linkedHashSet3.add("eighteen");
        linkedHashSet3.add("seventeen");
        linkedHashSet3.add("sixteen");
        linkedHashSet3.add("fourteen");
        linkedHashSet3.add("eleven");
        // initializing treeSet1
        treeSet1.add("four");
        treeSet1.add("seven");
        treeSet1.add("ten");
        treeSet1.add("sixteen");

        System.out.println("HashSet1       : " + hashSet1);
        System.out.println("LinkedHashSet1 : " + linkedHashSet1);
        System.out.println("LinkedHashSet2 : " + linkedHashSet2);
        System.out.println("LinkedHashSet3 : " + linkedHashSet3);
        System.out.println("TreeSet1       : " + treeSet1);

/*
        LinkedHashSet<String> unionLinkedSet = uis.union(linkedHashSet1, linkedHashSet2, linkedHashSet3);
        System.out.println("union as LinkedHashSet only: " + unionLinkedSet);
        HashSet<String> unionSet1 = (HashSet<String>) uis.union(hashSet1, linkedHashSet1, treeSet1);
        System.out.println("union as HashSet (mixed): " + unionSet1);
        TreeSet<String> unionSet2 = (TreeSet<String>) uis.union(hashSet1, linkedHashSet1, treeSet1);
        System.out.println("union as TreeSet (mixed): " + unionSet2);
*/
/*
        Set<String> intersectSet1 = uis.intersect(hashSet1, linkedHashSet1);
        System.out.println("intersect hashSet1 & linkedHashSet1: " + intersectSet1);
        Set<String> intersectSet2 = uis.intersect(hashSet1, treeSet1);
        System.out.println("intersect hashSet1 & treeSet1: " + intersectSet2);
        Set<String> intersectSet3 = uis.intersect(hashSet1, linkedHashSet1, treeSet1);
        System.out.println("intersect hashSet1, linkedHashSet1 & treeSet1: " + intersectSet3);
*/
    }
}
