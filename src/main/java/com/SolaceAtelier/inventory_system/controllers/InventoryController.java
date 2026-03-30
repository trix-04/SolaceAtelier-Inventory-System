package com.SolaceAtelier.inventory_system.controllers;

import com.SolaceAtelier.inventory_system.models.Product;
import com.SolaceAtelier.inventory_system.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class InventoryController {

    @Autowired
    private ProductRepository productRepo;

    // 1. HOME PAGE
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // 2. ABOUT PAGE
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    // 3. LOCATIONS PAGE
    @GetMapping("/locations")
    public String locations() {
        return "locations";
    }

    // 4. LIST VIEW (WITH SERVER-SIDE PAGINATION & SORTING)
    @GetMapping("/inventory")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF', 'CUSTOMER')")
    public String viewInventory(@RequestParam(required = false) String brand,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int size,
                                @RequestParam(defaultValue = "name") String sortField,
                                Model model) {
        
        // Define pagination and sorting parameters
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortField).ascending());
        Page<Product> productPage;

        // Filter by Brand if provided
        if (brand != null && !brand.isEmpty()) {
            productPage = productRepo.findByBrandContaining(brand, pageable);
        } else {
            productPage = productRepo.findAll(pageable);
        }

        // Add attributes for Thymeleaf rendering
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("brand", brand);
        model.addAttribute("sortField", sortField);

        return "inventory-list";
    }

    // 5. ADD FORM (ADMIN, STAFF only)
    @GetMapping("/inventory/add")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    // 6. SAVE FORM (ADMIN, STAFF only)
    @PostMapping("/inventory/save")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    public String saveProduct(@Valid @ModelAttribute Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "add-product";
        }
        productRepo.save(product);
        return "redirect:/inventory";
    }

    // 7. DELETE PRODUCT (ADMIN only)
    @GetMapping("/inventory/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProduct(@PathVariable Long id) {
        productRepo.deleteById(id);
        return "redirect:/inventory";
    }

    // 8. SHOW EDIT FORM (ADMIN only)
    @GetMapping("/inventory/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "edit-product"; 
    }

    // 9. UPDATE PRODUCT (ADMIN only)
    @PostMapping("/inventory/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateProduct(@PathVariable Long id, @Valid @ModelAttribute Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-product";
        }
        product.setId(id); // Required to ensure update vs. create
        productRepo.save(product);
        return "redirect:/inventory";
    }
}