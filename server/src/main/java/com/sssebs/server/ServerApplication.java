package com.sssebs.server;

import com.sssebs.server.model.GroceryItem;
import com.sssebs.server.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class ServerApplication implements CommandLineRunner {

	@Autowired
	ItemRepo itemRepo;
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-------------CREATE GROCERY ITEMS-------------------------------\n");

		createStudent();

		System.out.println("\n----------------SHOW ALL GROCERY ITEMS---------------------------\n");

		showAllGroceryItems();

		System.out.println("\n--------------GET ITEM BY NAME-----------------------------------\n");

		getGroceryItemByName("Whole Wheat Biscuit");

		System.out.println("\n-----------GET ITEMS BY CATEGORY---------------------------------\n");

		getItemsByCategory("millets");

		System.out.println("\n-----------UPDATE CATEGORY NAME OF SNACKS CATEGORY----------------\n");

		updateCategoryName("snacks");

		System.out.println("\n----------DELETE A GROCERY ITEM----------------------------------\n");

		deleteGroceryItem("Kodo Millet");

		System.out.println("\n------------FINAL COUNT OF GROCERY ITEMS-------------------------\n");

		findCountOfGroceryItems();

		System.out.println("\n-------------------THANK YOU---------------------------");
	}

	//CREATE
	void createStudent() {
		System.out.println("Student Data creation started...");
		itemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
		itemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
		itemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
		itemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
		itemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
		System.out.println("Data creation complete...");
	}

	// READ
	// 1. Show all the data
	public void showAllGroceryItems() {

		itemRepo.findAll().forEach(item -> System.out.println(getItemDetails(item)));
	}
	// 2. Get item by name
	public void getGroceryItemByName(String name) {
		System.out.println("Getting item by name: " + name);
		GroceryItem item = itemRepo.findItemByName(name);
		System.out.println(getItemDetails(item));
	}

	// 3. Get name and quantity of a all items of a particular category
	public void getItemsByCategory(String category) {
		System.out.println("Getting items for the category " + category);
		List<GroceryItem> list = itemRepo.findAll(category);

		list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
	}

	// 4. Get count of documents in the collection
	public void findCountOfGroceryItems() {
		long count = itemRepo.count();
		System.out.println("Number of documents in the collection: " + count);
	}
	// Print details in readable form

	public String getItemDetails(GroceryItem item) {

		System.out.println(
				"Item Name: " + item.getName() +
						", \nQuantity: " + item.getQuantity() +
						", \nItem Category: " + item.getCategory()
		);

		return "";
	}

	public void updateCategoryName(String category) {

		// Change to this new value
		String newCategory = "munchies";

		// Find all the items with the category snacks
		List<GroceryItem> list = itemRepo.findAll(category);

		list.forEach(item -> {
			// Update the category in each document
			item.setCategory(newCategory);
		});

		// Save all the items in database
		List<GroceryItem> itemsUpdated = itemRepo.saveAll(list);

		if(itemsUpdated != null)
			System.out.println("Successfully updated " + itemsUpdated.size() + " items.");
	}

	// DELETE
	public void deleteGroceryItem(String id) {
		itemRepo.deleteById(id);
		System.out.println("Item with id " + id + " deleted...");
	}


}
