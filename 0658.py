if __name__ == '__main__':
	ts = [0, 0, 0, 1, 1]
	
	head = ts[0:4]
	while True:
		tail = ts[len(ts)-4:]
		if head == tail:
			break
		ts.append(sum(tail) % 17)

	mod = len(ts) - 4

	q = int(input())
	for _ in range(q):
		n = int(input())
		print(ts[(n - 1) % mod])

