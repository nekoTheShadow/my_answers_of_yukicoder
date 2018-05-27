using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


public class Program
{
    static void Main(string[] args)
    {
        var tokens = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        var target = tokens[0];
        var n = tokens[1];

        var rank = 1;
        for (int i = 0; i < n - 1; i++)
        {
            var height = int.Parse(Console.ReadLine());
            if (target < height)
            {
                rank++;
            }
        }

        var x = rank % 10;
        var suffix = x == 1 ? "st" :
                     x == 2 ? "nd" :
                     x == 3 ? "rd" : "th";
        var ans = rank.ToString() + suffix;

        Console.WriteLine(ans);
    }
}

