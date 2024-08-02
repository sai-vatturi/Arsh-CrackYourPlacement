class Solution {
    public String simplifyPath(String path) {
        String[] p = path.split("/");
        Stack<String> st = new Stack<>();

        for (int i = 0; i < p.length; i++) {
            if (p[i].equals(".") || p[i].equals("")) {
                continue;
            } else if (p[i].equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else {
                st.push(p[i]);
            }
        }

        if (st.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
            sb.insert(0, "/");
        }

        return sb.toString();
    }
}

// The task is to transform UNIX style file system to Simplified Canonical Path

// Unix style rules
// Rule - 1: '.' signifies the current directory
// Rule - 2: ".." denotes moving up one directory level
// Rule - 3: "//" are interpreted as a single slash.
// Rule - 4: "..." sequences of periods as valid names for files or directories

// Canonical path rules:
// Rule 1: '/' It must start with a single slash
// Rule 2: '/' Directories with path should be seperated by a single slash
// Rule 3: '/' It should not end with a slash, unless its the root directory
// Rule 4: It should exclude any single or double periods used to denote current or parent directories

// We can simply do this by using a stack
// 1. Split the directory into an array by using / as a placeholder
// 2. Now look at the algorithm
//      - if word or multiple periods, push it into the stack
//      - if single '.' do nothing
//      - if double '..' pop the top most from stack
// 3. in the last, pop the element from the stack and build a string