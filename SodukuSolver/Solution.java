public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean helper(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (int m = 1; m <= 9; m++) {
                        board[i][j] = (char) (m + '0');
                        if (isValid(board, i, j) && helper(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int x, int y) {
        for (int j = 0; j < board[0].length; j++) {
            if (j != y && board[x][j] == board[x][y]) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (i != x && board[i][y] == board[x][y]) {
                return false;
            }
        }

        int startX = 3 * (x / 3);
        int startY = 3 * (y / 3);

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (i != x && j != y && board[i][j] == board[x][y]) {
                    return false;
                }
            }
        }

        return true;
    }
