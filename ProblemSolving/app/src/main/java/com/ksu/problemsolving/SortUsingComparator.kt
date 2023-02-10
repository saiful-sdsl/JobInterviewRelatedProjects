package com.ksu.problemsolving

class SortUsingComparator {


    class Name(val firstName: String, val lastName: String){
        override fun toString(): String {
            return "$firstName $lastName"
        }
    }

    class NameSortComparatorUsingFirstName: Comparator<Name>{

        override fun compare(p0: Name?, p1: Name?): Int {
            if (p0 == null||p1 == null){
                return 0
            }
            else return p0.firstName.compareTo(p1.firstName)
        }
    }

    class NameSortComparatorUsingLastName: Comparator<Name>{

        override fun compare(p0: Name?, p1: Name?): Int {
            if (p0 == null||p1 == null){
                return 0
            }
            else return p0.lastName.compareTo(p1.lastName)
        }
    }

}