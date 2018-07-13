using System;
using System.Linq;

namespace _712
{
    class Program
    {
        static void Main(string[] args)
        {
            var first = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            var n = first[0];
            var m = first[1];

            var count = 0;
            for (int i = 0; i < n; i++)
            {
                var line = Console.ReadLine();
                count += line.Count(ch => ch == 'W');
            }

            Console.WriteLine(count);
        }
    }
}
