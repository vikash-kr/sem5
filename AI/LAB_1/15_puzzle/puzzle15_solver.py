#!/usr/bin/python

from puzzle_solver import Puzzle


class Puzzle15(Puzzle):

    """15-puzzle"""

    def __init__(self, start):
        super(Puzzle15, self).__init__(start, [[1, 2, 3, 4], [5, 6, 7,
                8], [9, 10, 11, 12], [13, 14, 15, 0]])

    def solvable(self):
        """Checks if 15-puzzle is solvable from current state to goal state"""

        flattened_state = sum(self.start, [])
        return (True if (Puzzle.get_inversion_count(flattened_state)
                ^ 4 - Puzzle.get_blank_position(self.start)[0])
                & 1 else False)


def main():
    input_file = open('input_15.txt', 'r')
    start = [list(map(int, input_file.readline().strip().split()))
             for _ in range(4)]
    input_file.close()
    puzzle = Puzzle15(start)
    if puzzle.solvable():
        puzzle.search()
        output_file = open('out.txt', 'w')
        output_file.write('SEARCH ALGORITHM : '
                          + puzzle.search_algorithm + '\n')
        output_file.write('NUMBER OF MOVES : ' + str(len(puzzle.moves)
                          - 1) + '\n')
        output_file.close()
        for move in puzzle.moves:
            puzzle.display_board(move)
    else:
        print ('PUZZLE IS NOT SOLVABLE.')


if __name__ == '__main__':
    main()

