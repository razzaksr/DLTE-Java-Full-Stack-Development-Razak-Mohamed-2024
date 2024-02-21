package explore.oop.innerclasses;

import java.util.Arrays;

public class NonInner {
    public static void main(String[] args) {
        System.out.println(Record.stocks.length);
        Record record=new Record();
        record.show();
        Record.Search search=record.new Search();
        Arrays.sort(Record.stocks);
        System.out.println(search.binary(1200.5,0,Record.stocks.length-1));
    }
}

class Record{
    static double[] stocks={1200.5,3545.6,345.6,345.78,5676.7,23454.67};
    class Search{
        public int binary(double data,int start, int end){
            if(start<end){
                int mid=start+(end-start)/2;// 6-0/2>> 3+0>> 3
                if(stocks[mid]==data)
                    return mid;
                else if(stocks[mid]>data)
                    return binary(data,start,mid-1);
                else
                    return binary(data,mid+1,end);
            }
            else
                return -1;
        }
    }
    public void show(){
        System.out.println(Arrays.toString(stocks));
    }
}