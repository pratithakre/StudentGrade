import java.util.*;
class demo{
    // Function to sort an array of 0s, 1s, and 2s
    public static void main(String ar[]) {
        // code here
		int arr[]={1,4,2,0,6,0,3,0};
		ArrayList t= new ArrayList();
		for(int i:arr)
		{
			t.add(i);
		}
        // int i,j,t;
        // for(i=0;i<arr.length;i++)
        // {
            // for(j=arr.length-1;j>0;j--)
            // {
                // if(arr[j]<arr[j-1])
                // {
                // t=arr[j];
                // arr[j]=arr[j-1];
                // arr[j-1]=t;
                // }
            // }
        // }
		// for(i=0;i<arr.length;i++)
		// {
			System.out.print(t);
		// }
       
    }
}