using System;
using System.Collections.Generic;
using System.Linq;


class Program
{
    static void Main(string[] args)
    {
        var talls = new Dictionary<char, int>();
        for (char name = 'A'; ; name++)
        {
            var line = Console.ReadLine();
            if (line == null) break;
            talls.Add(name, int.Parse(line));
        }

        foreach (var name in talls.Keys.OrderByDescending((name) => talls[name])) {
            Console.WriteLine(name);
        }
    }
}
