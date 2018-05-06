using System;
using System.Collections.Generic;
using System.Linq;


class Program
{
    static void Main(string[] args)
    {
        var tokens = Console.ReadLine().Split(' ').Select(long.Parse).ToArray();
        var n = tokens[0];
        var m = tokens[1];

        var fibs = new Dictionary<long, long>();
        fibs.Add(1, 0 % m);
        fibs.Add(2, 1 % m);
        for (long i = 3; i <= n; i++) fibs.Add(i, (fibs[i - 2] + fibs[i - 1]) % m);

        var ans = fibs[n];
        Console.WriteLine(ans);

        Console.ReadKey();
    }
}
