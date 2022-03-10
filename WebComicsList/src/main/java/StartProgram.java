

import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a Publisher: ");
			String publisher = in.nextLine();
			System.out.print("Enter a Title: ");
			String title = in.nextLine();
			System.out.print("Enter a Volume: ");
			int volume = in.nextInt();
			System.out.print("Enter an Issue: ");
			int issue = in.nextInt();
			ListItem toAdd = new ListItem(publisher, title, volume, issue);
			lih.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the publisher to delete: ");
			String publisher = in.nextLine();
			System.out.print("Enter the title to delete: ");
			String title = in.nextLine();
			System.out.print("Enter the volume to delete: ");
			int volume = in.nextInt();
			System.out.print("Enter the issue to delete: ");
			int issue = in.nextInt();
			ListItem toDelete = new ListItem(publisher, title, volume, issue);
			lih.deleteItem(toDelete);
		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Publisher");
			System.out.println("2 : Search by Title");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the publisher name: ");
				String publisherName = in.nextLine();
				foundItems = lih.searchForItemByPublisher(publisherName);
			} else  {
				System.out.print("Enter the title: ");
				String titleName = in.nextLine();
				foundItems = lih.searchForItemByTitle(titleName);
			} 

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getTitle() + " from " + toEdit.getPublisher());
				System.out.println("1 : Update Publisher");
				System.out.println("2 : Update Title");
				System.out.println("3 : Update Volume");
				System.out.println("4 : Update Issue");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Publisher: ");
					String newPublisher = in.nextLine();
					toEdit.setPublisher(newPublisher);
				} else if (update == 2) {
					System.out.print("New Title: ");
					String newTitle = in.nextLine();
					toEdit.setTitle(newTitle);
				} else if (update == 3) {
					System.out.print("New Volume: ");
					int newVolume = in.nextInt();
					toEdit.setVolume(newVolume);
				} else if (update == 4) {
					System.out.print("New Issue: ");
					int newIssue = in.nextInt();
					toEdit.setIssue(newIssue);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our Spectacular Snyder Comics list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListItem> allItems = lih.showAllItems();
			for(ListItem singleItem : allItems){
				System.out.println(singleItem.returnItemDetails());
			}

		}

	}
