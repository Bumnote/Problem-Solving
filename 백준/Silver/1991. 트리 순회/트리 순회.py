from sys import stdin

input = stdin.readline


# preorder: D -> L -> R
def preorder(root):
    if root == '.':
        return
    print(root, end="")
    preorder(tree[root]['left'])
    preorder(tree[root]['right'])


# inorder: L -> D -> R
def inorder(root):
    if root == ".":
        return
    inorder(tree[root]['left'])
    print(root, end="")
    inorder(tree[root]['right'])


# postorder: L -> R -> D
def postorder(root):
    if root == ".":
        return

    postorder(tree[root]['left'])
    postorder(tree[root]['right'])
    print(root, end="")


n = int(input().rstrip())  # n: 노드의 개수

tree = {}
for _ in range(n):
    node, left, right = input().split()
    tree[node] = {'left': left, 'right': right}

preorder('A')
print()
inorder('A')
print()
postorder('A')
