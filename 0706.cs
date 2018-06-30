using System;
using System.Collections.Generic;
using System.Linq;

namespace _706
{
    class Program
    {
        static void _Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var insects = new List<string>();
            for (int i = 0; i < n; i++)
            {
                insects.Add(Console.ReadLine());
            }

            var answer = insects.GroupBy(insect => insect.Count(ch => ch == '^'))
                                .OrderByDescending(entry => entry.Count())
                                .ThenByDescending(entry => entry.Key)
                                .First();
            Console.WriteLine(answer.Key);
        }
    }
}
