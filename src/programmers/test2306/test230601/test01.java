package programmers.test2306.test230601;

import java.util.*;

public class test01 {
    public static void main( String[] args ) {
        test01 test01 = new test01();
        // List<String[]>가 주어질 때 중복된 개수를 리턴하는 메서드를 만들어라.
        // ex. { "a", "b", "c", "1" },
        //     { "a", "b", "c", "1" },
        //     { "a", "b", "c", "1" },
        //     { "e", "f", "g", "1" },
        //     { "e", "f", "g", "1" },
        //     { "i", "j", "k", "1" }
        // >>
        //      { "a", "b", "c", "3" },
        //      { "e", "f", "g", "2" },
        //      { "i", "j", "k", "1" }

        List< String[] > list = new ArrayList<>();
        list.add( new String[] { "a", "b", "c", "1" } );
        list.add( new String[] { "a", "b", "c", "1" } );
        list.add( new String[] { "a", "b", "c", "1" } );
        list.add( new String[] { "a", "b", "c", "1" } );
        list.add( new String[] { "e", "f", "g", "1" } );
        list.add( new String[] { "i", "j", "k", "1" } );

        List< String[] > list2 = test01.deleteOverlap( list );

        for ( int i = 0 ; i < list2.size() ; i++ ) {
            int count = 0;
            for ( int j = 0 ; j < list.size() ; j++ ) {
                if ( Arrays.equals( list2.get( i ), list.get( j ) ) ) {
                    count++;
                }
            }
            list2.get( i )[3] = Integer.toString( count );
        }

        System.out.println( "count 후 list 2 : " );
        for ( int i = 0 ; i < list2.size() ; i++ ) {
            System.out.println( Arrays.toString( list2.get( i ) ) );
        }
    }

    public boolean containStrArr( List< String[] > list, String[] strArr ) {
        boolean containStrArr = false;
        for ( int i = 0 ; i < list.size() ; i++ ) {
            if ( Arrays.equals( list.get( i ), strArr ) ) {
                containStrArr = true;
                break;
            }
        }
        return containStrArr;
    }

    public List< String[] > deleteOverlap( List< String[] > list ) {
        List< String[] > list2 = new ArrayList<>();
        for ( int i = 0 ; i < list.size() ; i++ ) {
            String[] strArr = list.get( i );
            if ( !containStrArr( list2, strArr ) ) {
                list2.add( strArr );
            }
        }
        return list2;
    }
}
