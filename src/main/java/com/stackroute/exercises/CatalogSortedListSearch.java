package com.stackroute.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogSortedListSearch {

	List<String> sortedCatalogList;

	// write here logic to get sorted Array List which is a global class variable
	public String catalogListSorter(List<String> unSortedCatalogList) {

		if (unSortedCatalogList == null) {
			return "The catalog list is null";
		}

		boolean containNullOrNot = unSortedCatalogList.contains(null);
		if (containNullOrNot) {
			return "The catalog List contains empty or null or blank space as a value";
		}

		if (unSortedCatalogList.isEmpty()) {
			return "The catalog List is empty";
		}

		sortedCatalogList = new ArrayList<>(unSortedCatalogList);

		Collections.sort(sortedCatalogList);

		for (String catalog : sortedCatalogList) {

			if (catalog.isEmpty() || catalog.isBlank()) {
				return "The catalog List contains empty or null or blank space as a value";
			}

		}

		String sortedCatalog = sortedCatalogList.stream().collect(Collectors.joining(", ", "[", "]"));

		return sortedCatalog;

	}

	public static final String capitalize(String input) {
		if (input == null || input.length() == 0) {
			return input;
		} else {
			return input.substring(0, 1).toUpperCase() + input.substring(1);
		}

	}

	// write here logic to search the input value in sorted Array List
	public String catalogListSearcher(String value) {

		if (value == null) {
			return "Input is not accepted";
		}

		if (value.isEmpty() || value.isBlank()) {
			return "Input is not accepted";
		}

		String givenInputValue = CatalogSortedListSearch.capitalize(value);
		boolean InputValue = sortedCatalogList.contains(givenInputValue);
		if (InputValue) {
			return "Found: Reebok";
		}

		for (String catalog : sortedCatalogList) {

			if (!catalog.contains(value)) {
				return "Not Found";
			}
			if (!catalog.isEmpty()) {
				return "Input is not accepted";
			}

		}

		return null;
	}
}
