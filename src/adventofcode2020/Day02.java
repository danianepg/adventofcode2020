package adventofcode2020;

import java.util.List;

import adventofcode2020.util.ReadInput;

/**
 * --- Day 2: Password Philosophy --- Your flight departs in a few days from the
 * coastal airport; the easiest way down to the coast from here is via toboggan.
 * 
 * The shopkeeper at the North Pole Toboggan Rental Shop is having a bad day.
 * "Something's wrong with our computers; we can't log in!" You ask if you can
 * take a look.
 * 
 * Their password database seems to be a little corrupted: some of the passwords
 * wouldn't have been allowed by the Official Toboggan Corporate Policy that was
 * in effect when they were chosen.
 * 
 * To try to debug the problem, they have created a list (your puzzle input) of
 * passwords (according to the corrupted database) and the corporate policy when
 * that password was set.
 * 
 * For example, suppose you have the following list:
 * 
 * 1-3 a: abcde </br>
 * 1-3 b: cdefg </br>
 * 2-9 c: ccccccccc </br>
 * 
 * Each line gives the password policy and then the password. The password
 * policy indicates the lowest and highest number of times a given letter must
 * appear for the password to be valid. For example, 1-3 a means that the
 * password must contain a at least 1 time and at most 3 times.
 * 
 * In the above example, 2 passwords are valid. The middle password, cdefg, is
 * not; it contains no instances of b, but needs at least 1. The first and third
 * passwords are valid: they contain one a or nine c, both within the limits of
 * their respective policies.
 * 
 * How many passwords are valid according to their policies?
 *
 */
public class Day02 {

	private static void part1() {
		List<String> input = ReadInput.readAsListString("input-day02");
		int valids = 0;

		for (int i = 0; i < input.size(); i++) {

			String[] parts = input.get(i).split(" ");
			int min = Integer.valueOf(parts[0].split("-")[0]);
			int max = Integer.valueOf(parts[0].split("-")[1]);
			String letter = parts[1];
			String psw = parts[2];

			int occur = (int) psw.chars().filter(ch -> ch == letter.charAt(0)).count();
			if (occur >= min && occur <= max) {
				valids++;
			}

		}

		System.out.println(valids);

	}

	/**
	 * --- Part Two --- While it appears you validated the passwords correctly, they
	 * don't seem to be what the Official Toboggan Corporate Authentication System
	 * is expecting.
	 * 
	 * The shopkeeper suddenly realizes that he just accidentally explained the
	 * password policy rules from his old job at the sled rental place down the
	 * street! The Official Toboggan Corporate Policy actually works a little
	 * differently.
	 * 
	 * Each policy actually describes two positions in the password, where 1 means
	 * the first character, 2 means the second character, and so on. (Be careful;
	 * Toboggan Corporate Policies have no concept of "index zero"!) Exactly one of
	 * these positions must contain the given letter. Other occurrences of the
	 * letter are irrelevant for the purposes of policy enforcement.
	 * 
	 * Given the same example list from above:
	 * 
	 * 1-3 a: abcde is valid: position 1 contains a and position 3 does not. <br>
	 * 1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b. <br>
	 * 2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c. <br>
	 * 
	 * How many passwords are valid according to the new interpretation of the
	 * policies?
	 */
	private static void part2() {

		List<String> input = ReadInput.readAsListString("input-day02");
		int valids = 0;

		for (int i = 0; i < input.size(); i++) {

			String[] parts = input.get(i).split(" ");
			int min = Integer.valueOf(parts[0].split("-")[0]) - 1;
			int max = Integer.valueOf(parts[0].split("-")[1]) - 1;
			String letter = parts[1];
			String psw = parts[2];

			boolean first = psw.charAt(min) == letter.charAt(0);
			boolean last = psw.charAt(max) == letter.charAt(0);

			if (first ^ last) {
				valids++;
			}

		}

		System.out.println("Part 2: " + valids);

	}

	public static void main(final String[] args) {
		part1();
		part2();
	}

}
