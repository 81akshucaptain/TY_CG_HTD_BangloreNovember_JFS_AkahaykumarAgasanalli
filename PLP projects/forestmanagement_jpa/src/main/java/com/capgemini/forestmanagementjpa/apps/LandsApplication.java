package com.capgemini.forestmanagementjpa.apps;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmanagementjpa.dao.LandsDAO;
import com.capgemini.forestmanagementjpa.dto.LandsBean;
import com.capgemini.forestmanagementjpa.exceptions.LandsAppException;
import com.capgemini.forestmanagementjpa.exceptions.ProductAppException;
import com.capgemini.forestmanagementjpa.exceptions.VallidationExceptionFMS;
import com.capgemini.forestmanagementjpa.factory.ForestFactoryFmJpa;
import com.capgemini.forestmanagementjpa.validations.Validations;

public class LandsApplication {
	public void lands() {
		LandsDAO land = ForestFactoryFmJpa.createInstanceOfLandsDAOImpl();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("1.Enter one to Add land details");
				System.out.println("2.Enter two to Search land details");
				System.out.println("3.Enter three to Update land details");
				System.out.println("4.Enter four to Delete land details");
				System.out.println("5.Enter five to get All land details");
				System.out.println("6.Enter six to return home");
				String choice1 = scanner.next();
				if (Validations.numberValidation(choice1)) {
					int choice2 = Integer.parseInt(choice1);

					switch (choice2) {
					case 1:
						LandsBean landBean1 = new LandsBean();

						boolean stay1 = true;
						while (stay1) {
							try {
								System.out.println("Enter ID of Land: ");
								String landId1 = scanner.next();
								if (Validations.numberValidation(landId1)) {
									Integer landId = Integer.parseInt(landId1);
									if (landId > 0) {
										landBean1.setLandId(landId);
										stay1 = false;
									} else {
										throw new LandsAppException(
												"Enter the value which must be greater than zero..!");
									}
								}
							} catch (Exception e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay2 = true;
						while (stay2) {
							try {
								System.out.println("Enter Land size (In-acres): ");

								String size = scanner.next();
								if (Validations.numberValidation(size)) {
									if (!(size.equals(0))) {
										landBean1.setLandSize(size);
										stay2 = false;
									} else {
										throw new LandsAppException(
												"Enter the value which must be greater than zero..!");
									}
								}
							} catch (Exception e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}
						boolean stay4 = true;
						while (stay4) {
							try {
								System.out.println("Enter Land Location: ");
								String resources = scanner.next();
								if (Validations.alphabetsValidation(resources)) {
									landBean1.setLandLocation(resources);
									stay4 = false;
								}
							} catch (VallidationExceptionFMS e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay3 = true;
						while (stay3) {
							try {
								System.out.println("Enter Land Resources: ");
								String resources = scanner.next();
								if (Validations.alphabetsValidation(resources)) {
									landBean1.setLandResources(resources);
									stay3 = false;
								}
							} catch (VallidationExceptionFMS e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}
						boolean add = land.addLands(landBean1);
						if (add) {
							System.out.println("Added..successfully..!");
						} else {
							System.err.println("failed to add land details ");
						}
						break;

					case 2:
						boolean s_stay = true;
						try {
							System.out.println("enter the LandID to search Lnad: ");
							String LandToSearch = scanner.next();
							if (Validations.numberValidation(LandToSearch)) {
								Integer LandToSearch2 = Integer.parseInt(LandToSearch);
								if (LandToSearch2 > 0) {
									LandsBean laBean = land.searchLands(LandToSearch2);
									if (laBean != null) {
										System.out.println(laBean);
									} else {
										System.err.println("No Data,land Not Found..!");
									}
								} else {
									s_stay = true;
									throw new ProductAppException("Enter vallid Land Id to search, must be positive");
								}
							}
						} catch (Exception e) {
							String message = e.getMessage();
							System.err.println(message);
						}
						break;

					case 3:
						LandsBean landBean2 = new LandsBean();

						boolean stay0 = true;
						while (stay0) {
							try {
								System.out.println("Enter ID of Land to update: ");
								String landId1 = scanner.next();
								if (Validations.numberValidation(landId1)) {
									Integer landId = Integer.parseInt(landId1);
									if (landId > 0) {
										landBean2.setLandId(landId);
										stay0 = false;
									} else {
										System.err.println("enter the Positive value, must be greater than zero..!");
									}
								}
							} catch (VallidationExceptionFMS e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay5 = true;
						while (stay5) {
							try {
								System.out.println("Enter Land size (In-acres) to update: ");
								String size = scanner.next();
								if (Validations.numberValidation(size)) {
									if (!(size.equals(0))) {
										landBean2.setLandSize(size);
										stay5 = false;
									} else {
										System.err.println("Enter positive value value..");
									}
								}
							} catch (Exception e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay6 = true;
						while (stay6) {
							try {
								System.out.println("Enter Land Resources to update: ");
								String resources = scanner.next();
								if (Validations.alphabetsValidation(resources)) {
									landBean2.setLandResources(resources);
									stay6 = false;
								}
							} catch (Exception e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean stay9 = true;
						while (stay9) {
							try {
								System.out.println("Enter Land Location to update: ");
								String resources = scanner.next();
								if (Validations.alphabetsValidation(resources)) {
									landBean2.setLandLocation(resources);
									stay9 = false;
								}
							} catch (VallidationExceptionFMS e) {
								String message = e.getMessage();
								System.err.println(message);
							}
						}

						boolean update = land.updateLands(landBean2.getLandId(), landBean2);
						if (update) {
							System.out.println("New Data Updated Successfully..GOOD DAY");
						} else {
							System.out.println("Failed to update New Data..!");
						}
						break;

					case 4:
						try {
							System.out.println("Enter The Land-ID to delete land:");
							String landToDelete = scanner.next();
							if (Validations.numberValidation(landToDelete)) {
								Integer landToSearch2 = Integer.parseInt(landToDelete);
								if (land.deleteLands(landToSearch2)) {
									System.out.println("Done with deletion..!");
								} else {
									System.err.println("No such LandId,try again");
								}
							}
						} catch (Exception e) {
							String message = e.getMessage();
							System.err.println(message);
						}
						break;
					case 5:
						List<LandsBean> landBeans = land.getAllLands();
						if (landBeans != null) {
							for (LandsBean landbean : landBeans) {
								System.out.println(landbean);
							}
						} else {
							System.out.println("No Land Details..!");
						}
						break;
					case 6:
						AdminApp app = new AdminApp();
						app.adminMain();
					default:
						System.err.println("Enter the valid choice to move further");
						break;

					}
				} else {
					System.err.println("Please enter the valid choice, in terms of Digit..!");
				}

			} catch (Exception e) {
				System.err.println("try again with valid input..!");
			}

		}
	}

}