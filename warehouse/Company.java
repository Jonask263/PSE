package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Compass;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Pen;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Ruler;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;

/**
 * Represents a company.
 *
 * A company stores items and processes orders.
 *
 * @author your name
 */
public final class Company {

	private final StorageRack itemStorageRack;
	private final Buffer orderBuffer;
	HashSet<Customer>customers;
	// TODO: Add data structure for exercise 1i here.

	// TODO add documentation here.

	/**
	 * creates a new company by creating a new Buffer, storage rack and a customer Collection/Set
	 * requires capacity größer 0
	 * ensures orderBuffer is initialized as new Buffer, itemStorageRack as new StorageRack and customers as new HashSet
	 */
	public Company(final int capacity) {
		orderBuffer = new Buffer();
		// TODO: implement exercises 1e and 1i here.
		itemStorageRack = new StorageRack(capacity); // TODO delete this line if necessary
		customers = new HashSet<Customer>();
	}

	// TODO add documentation here.

	/**
	 * Stores an item in the storage rack
	 * requires company to be initialized
	 * ensures stationeryItem has been added to itemStorageRack
	 * @param stationeryItem, the item to be stored
	 */
	public void storeInStorageRack(final StationeryItem stationeryItem) {
		itemStorageRack.addItem(stationeryItem);


		// TODO: implement exercise 1e here.
	}

	// TODO add documentation here.

	/**
	 * Processes orders by moving item from storage to buffer
	 * requires company to be initialized
	 * ensures item has been added to buffer, removed from storage rack, optional gift added to buffer, new customers registered
	 * @param identifier Identification of the item
	 * @param customer The customer that ordered the item
	 */
	public void processIncomingOrder(final Identifier identifier, final Customer customer) {
		int nummer = itemStorageRack.getCompartmentNumberOf(identifier).get();
		StationeryItem item = itemStorageRack.getItem(nummer).get();
		orderBuffer.items3.add(item);
		if(!customers.contains(customer)){
			StationeryItem bonusItem = getBonusItem();
			orderBuffer.items3.add(bonusItem);
			customers.add(customer);
		}
		itemStorageRack.removeItem(itemStorageRack.items2.get(identifier)); //maybe noch aus items löschen?
		System.out.println(orderBuffer.items3);
		// TODO implement exercises 1h and 1i here.

	}

	/*@
	@ ensures \result != null;
	@ ensures \result.getIdentification().getType() == ItemType.PRESENT;
	@*/
	/**
	 * Generates a bonus item for marketing reasons.
	 *
	 * @return A marketing bonus item.
	 */
	private /*@ pure @*/ StationeryItem getBonusItem() {

		switch ((new Random().nextInt(3))) {
			case 1:
				return new Compass(new Identifier(), "A marketing bonus item.");
			case 2:
				return new Ruler(new Identifier(), "A marketing bonus item.");
			default:
				return new Pen(new Identifier(), "A marketing bonus item.");
		}
	}

	/**
	 * If items are waiting for packaging, takes the next available item from the buffer and return it.
	 *
	 * @return Optional next available item for packaging, or an empty Optional if there is none.
	 */
	public Optional<StationeryItem> takeItemForPackaging() {
		if (orderBuffer.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(orderBuffer.releaseItem());
		}
	}
}
