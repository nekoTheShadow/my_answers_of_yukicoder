using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


class Program
{
    static void Main(string[] args)
    {
        var n = int.Parse(Console.ReadLine());
        var words1 = Console.ReadLine().Split();
        var words2 = Console.ReadLine().Split();
        
        var idx = Enumerable.Range(0, n).First((i) => words1[i] != words2[i]);

        Console.WriteLine(idx + 1);
        Console.WriteLine(words1[idx]);
        Console.WriteLine(words2[idx]);
    }
}
