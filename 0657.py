if __name__ == '__main__':
	q = int(input())
	ns = tuple(int(input()) for _ in range(q))

	ts = [0, 0, 0, 0, 1]
	for i in range(5, max(ns) + 1):
		ts.append(sum(ts[-1:-5:-1]) % 17)

	for n in ns:
		print(ts[n])
