package nl.vaneijndhoven.testapp;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import java.util.Arrays;

public class Sorter {

    private static final Logger LOG = LoggerFactory.getLogger(Sorter.class);

    public static void main(String[] args) {
        // Create an HTTP server which simply returns "Hello World!" to each request.
        Vertx.vertx().createHttpServer().requestHandler(Sorter::handle).listen(8080);
        LOG.info("Webserver started.");
    }

    private static void handle(HttpServerRequest request) {
        String bla = request.getParam("count");
        if (bla != null) {
            int n = Integer.valueOf(bla);
            int[] values = new int[n];
            while (n > 0) {
                values[n-1] = n;
                n--;
            }

            long start = System.currentTimeMillis();
            bubbleSort(values);
            long end = System.currentTimeMillis();

            LOG.info("Sorting completed in " + (end - start) + " ms");

            StringBuilder builder = new StringBuilder();
            Arrays.stream(values).forEach(val -> builder.append(val + ","));

            request.response().end("total = [" +builder + "]");
        } else {
            request.response().end("<html><body><form method=\"GET\"><input type=\"text\" name=\"count\"/><button type=\"submit\">submit</button></form></body></html>");
        }
    }

    public static void insertionSort( int [ ] num)
    {
        LOG.info("Using insertion sort for sorting.");
        int j;                     // the number of items sorted so far
        int key;                // the item to be inserted
        int i;

        for (j = 1; j < num.length; j++)    // Start with 1 (not 0)
        {
            key = num[ j ];
            for(i = j - 1; (i >= 0) && (num[ i ] < key); i--)   // Smaller values are moving up
            {
                num[ i+1 ] = num[ i ];
            }
            num[ i+1 ] = key;    // Put the key in its proper location
        }
    }

    public static void selectionSort ( int [ ] num )
    {
        LOG.info("Using selection sort for sorting.");
        int i, j, first, temp;
        for ( i = num.length - 1; i > 0; i -- )
        {
            first = 0;   //initialize to subscript of first element
            for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
            {
                if( num[ j ] < num[ first ] )
                    first = j;
            }
            temp = num[ first ];   //swap smallest found with element in position i.
            num[ first ] = num[ i ];
            num[ i ] = temp;
        }
    }

    public static void bubbleSort( int [ ] num )
    {
        LOG.info("Using bubble sort for sorting.");
        int j;
        boolean flag = true;   // set flag to true to begin first pass
        int temp;   //holding variable

        while ( flag )
        {
            flag= false;    //set flag to false awaiting a possible swap
            for( j=0;  j < num.length -1;  j++ )
            {
                if ( num[ j ] < num[j+1] )   // change to > for ascending sort
                {
                    temp = num[ j ];                //swap elements
                    num[ j ] = num[ j+1 ];
                    num[ j+1 ] = temp;
                    flag = true;              //shows a swap occurred
                }
            }
        }
    }
}