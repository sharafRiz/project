package phase1.Project;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockerMe {
	File directory;

	public void LockerMe() {
		directory = new File("C:\\LockedMe\\");
		if (!directory.exists())
			directory.mkdir();
	}

	static final String welcomeMsg = ("\n ** Welcome to LockedMe.com **"
			+ "\n\n================Developer Details==================" + "\nName-Sharaf Ali"
			+ "\nProject Name: LOckedMe.com");

	static final String mainMenu = "\nMAIN MENU - \nPlease select any of the following:" +
			"\n 1. Display file names in ascending order from root directory" +
			"\n 2. More Business operations" +
			"\n 3. Exit Program";

	static final String secondaryMenu = "\n Select any of the following" +
			"\n a. Add file" +
			"\n b. Delete file" +
			"\n c. Search file" +
			"\n d. Go back to Main Menu";

	void showMainMenu() {

		System.out.println(mainMenu);
		try {
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
				case 1: {
					listFile();
					showMainMenu();
				}

				case 2: {
					showSecondaryMenu();
				}
				case 3: {
					System.out.println("Thank You for using LockedMe");
					System.exit(0);
				}

				default:
					System.out.println("Please enter valid option 1, 2 or 3");
					showMainMenu();
			}
		} catch (Exception e) {
			System.out.println("Please enter valid option 1, 2 or 3");
			showMainMenu();
		}
	}

	void showSecondaryMenu() {
		System.out.println(secondaryMenu);
		try {

			Scanner scanner = new Scanner(System.in);
			char[] input = scanner.nextLine().toLowerCase().trim().toCharArray();
			char option = input[0];

			switch (option) {
				case 'a': {
					System.out.println("Enter file name: ");
					String filename = scanner.nextLine();
					addFile(filename);
				}
				case 'b': {
					System.out.println("Enter file name to delete: ");
					String filename = scanner.nextLine();
					deleteFile(filename);
				}
				case 'c': {
					System.out.println("Enter file name to Search: ");
					String filename = scanner.nextLine();
					searchFile(filename);
				}
				case 'd': {
					System.out.println("Going back to main menu...");
					showMainMenu();
					break;
				}
				default:
					System.out.println("Please Enter a, b, c or d");
					showSecondaryMenu();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Please Enter a, b, c or d");
			showSecondaryMenu();
		}
	}

	public void listFile() {

		LockerMe();

		if (directory.list().length == 0) {
			System.out.println("Folder is Empty");
		} else {
			String[] list = directory.list();
			System.out.println("The file in " + directory + " are:");
			Arrays.sort(list);
			for (String str : list) {
				System.out.println(str);
			}
		}
	}

	public void addFile(String filename) throws IOException {

		LockerMe();

		File filepath = new File("C:\\LockedMe\\" + filename);

		if (filepath.createNewFile()) {
			System.out.println("File Added " + filename);
		} else {
			System.out.println("File Exist");
		}
		showSecondaryMenu();
	}

	public void deleteFile(String filename) {

		LockerMe();

		File filepath = new File("C:\\LockedMe\\" + filename);
		String[] list = directory.list();
		for (String file : list) {
			if (filename.equals(file) && filepath.delete()) {
				System.out.println("File " + filename + " deleted from " + directory);
				showMainMenu();
				return;
			}
		}
		System.out.println("FNF: file not found");
		showSecondaryMenu();
	}

	public void searchFile(String filename) {
		LockerMe();
		File filepath = new File("C:\\LockedMe\\" + filename);
		String[] list = directory.list();
		for (String file : list) {
			if (filename.equals(file)) {
				System.out.println("File found in " + directory);
				return;
			}
		}
		System.out.println("FILE NOT FOUND");
		showSecondaryMenu();
	}

	public static void main(String[] args) {
		System.out.println(welcomeMsg);
		LockerMe menu = new LockerMe();
		menu.showMainMenu();
		// TODO Auto-generated method stub

	}

}