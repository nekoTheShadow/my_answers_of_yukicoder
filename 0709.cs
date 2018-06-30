using System;
using System.Collections.Generic;
using System.Linq;

namespace _709
{
    class Program
    {
        static void Main(string[] args)
        {
            var first = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            var n = first[0];
            var m = first[1];

            var wins = Enumerable.Repeat(0, n).ToList();
            var maxSkills = Enumerable.Repeat(0, m).ToList();
            var stacks = Enumerable.Range(0, m).Select(_ => new Stack<int>()).ToList();
            var answer = 0;

            for (int i = 0; i < n; i++)
            {
                var skills = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
                for (int j = 0; j < m; j++)
                {
                    if (maxSkills[j] < skills[j])
                    {
                        maxSkills[j] = skills[j];

                        while (stacks[j].Any())
                        {
                            var k = stacks[j].Pop();
                            if (--wins[k] == 0)
                            {
                                answer--;
                            }
                        }
                    }

                    if (maxSkills[j] == skills[j])
                    {
                        stacks[j].Push(i);
                        if (++wins[i] == 1)
                        {
                            answer++;
                        }
                    }
                }
                Console.WriteLine(answer);
            }

           
        }
    }
}
