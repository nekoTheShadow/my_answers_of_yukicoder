using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class Program
{
    static void Main(string[] args)
    {
        var tokens = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        var m = tokens[0];
        var n = tokens[1];

        var ans = m + n / 3.0;
        Console.WriteLine(ans);
    }
}
