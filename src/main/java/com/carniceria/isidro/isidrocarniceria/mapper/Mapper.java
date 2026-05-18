package com.carniceria.isidro.isidrocarniceria.mapper;

import java.util.List;

import com.carniceria.isidro.isidrocarniceria.customers.dto.CustomerDTO;
import com.carniceria.isidro.isidrocarniceria.orders.details.dto.DetailDTO;
import com.carniceria.isidro.isidrocarniceria.orders.details.dto.DetailResponseDTO;
import com.carniceria.isidro.isidrocarniceria.orders.details.entity.Detail;
import com.carniceria.isidro.isidrocarniceria.orders.dto.OrderDTO;
import com.carniceria.isidro.isidrocarniceria.orders.dto.OrderResponseDTO;
import com.carniceria.isidro.isidrocarniceria.orders.dto.OrderSummaryDTO;
import com.carniceria.isidro.isidrocarniceria.orders.entity.Order;
import com.carniceria.isidro.isidrocarniceria.orders.payments.dto.PaymentResponseDTO;
import com.carniceria.isidro.isidrocarniceria.orders.payments.entity.Payment;
import com.carniceria.isidro.isidrocarniceria.products.dto.ProductDTO;
import com.carniceria.isidro.isidrocarniceria.products.dto.ProductResponseDTO;
import com.carniceria.isidro.isidrocarniceria.products.entity.Product;

public class Mapper {

        public static ProductResponseDTO productToResponseDTO(Product product) {
                return new ProductResponseDTO(
                                product.getId(),
                                product.getDescription(),
                                product.getName(),
                                product.getCurrentPrice(),
                                product.getSaleUnit(),
                                product.isActive());
        }

        public static OrderSummaryDTO orderToSummaryDTO(Order order) {
                return new OrderSummaryDTO(
                                order.getId(),
                                order.getCustomer().getName(),
                                order.getStatus(),
                                order.getTotalMount());
        }

        public static PaymentResponseDTO paymentToResponseDTO(Payment payment) {
                CustomerDTO customerDTO = CustomerDTO.builder()
                                .id(payment.getCustomer().getId())
                                .name(payment.getCustomer().getName())
                                .phone(payment.getCustomer().getPhone())
                                .address(payment.getCustomer().getAddress())
                                .notes(payment.getCustomer().getNotes())
                                .build();

                OrderDTO orderDTO = new OrderDTO(
                                payment.getOrder().getId(),
                                payment.getOrder().getCustomer().getId(),
                                payment.getOrder().getCreateAt(),
                                payment.getOrder().getEstimatedDeliveryDate(),
                                payment.getOrder().getStatus(),
                                payment.getOrder().getTotalMount(),
                                payment.getOrder().getDeposit(),
                                payment.getOrder().getRemainingAmount(),
                                payment.getOrder().getNotes());

                return PaymentResponseDTO.builder()
                                .id(payment.getId())
                                .customer(customerDTO)
                                .order(orderDTO)
                                .amount(payment.getAmount())
                                .paidAt(payment.getPaidAt())
                                .remarks(payment.getRemarks())
                                .build();
        }

        public static OrderResponseDTO orderToResponseDTO(Order order) {

                CustomerDTO customerDTO = CustomerDTO.builder()
                                .id(order.getCustomer().getId())
                                .name(order.getCustomer().getName())
                                .phone(order.getCustomer().getPhone())
                                .address(order.getCustomer().getAddress())
                                .notes(order.getCustomer().getNotes())
                                .build();
                List<DetailDTO> details = order.getDetails()
                                .stream()
                                .map(Mapper::detailToDetailDTO)
                                .toList();

                return OrderResponseDTO.builder()
                                .id(order.getId())
                                .createAt(order.getCreateAt())
                                .estimatedDeliveryDate(order.getEstimatedDeliveryDate())
                                .status(order.getStatus())
                                .totalMount(order.getTotalMount())
                                .deposit(order.getDeposit())
                                .remainingAmount(order.getRemainingAmount())
                                .notes(order.getNotes())
                                .customer(customerDTO)
                                .details(details)
                                .build();
        }

        public static DetailResponseDTO detailToResponseDTO(Detail detail) {
                ProductDTO productDTO = ProductDTO.builder()
                                .id(detail.getProduct().getId())
                                .name(detail.getProduct().getName())
                                .description(detail.getProduct().getDescription())
                                .currentPrice(detail.getProduct().getCurrentPrice())
                                .saleUnit(detail.getProduct().getSaleUnit())
                                .isActive(detail.getProduct().isActive())
                                .build();

                OrderDTO orderDTO = new OrderDTO(
                                detail.getOrder().getId(),
                                detail.getOrder().getCustomer().getId(),
                                detail.getOrder().getCreateAt(),
                                detail.getOrder().getEstimatedDeliveryDate(),
                                detail.getOrder().getStatus(),
                                detail.getOrder().getTotalMount(),
                                detail.getOrder().getDeposit(),
                                detail.getOrder().getRemainingAmount(),
                                detail.getOrder().getNotes());

                return DetailResponseDTO.builder()
                                .id(detail.getId())
                                .product(productDTO)
                                .order(orderDTO)
                                .salePrice(detail.getSalePrice())
                                .subtotal(detail.getSubtotal())
                                .build();
        }

        private static DetailDTO detailToDetailDTO(Detail detail) {
                return new DetailDTO(
                                detail.getId(),
                                detail.getProduct().getId(),
                                detail.getOrder().getId(),
                                detail.getSalePrice(),
                                detail.getSubtotal());
        }

}
