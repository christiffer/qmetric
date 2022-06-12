# Notes

- A Discount is just a different type of Item with negative price
- A Discount is valid against a given Basket
    - A discount should understand some ID for an Item/Product and know if it applies
- A Basket or Product should not understand Discounts

## Design

- Refactor `Basket`, `Item`, `Product`
    - `Basket` needs to know quantities & SKUs
- `DiscountService` has a list of Discounts active in the systema
    - `DiscountService` can get a list of valid Discounts for a list of Products
    - A `Discount` is valid based on Product SKU
    - A `Discount` is an item with a dynamic price.
        - Eg. It could be "50% off" so the price will be affected by basket

##

Dependency Changes

- I have removed `junit-vintage` as there were no vintage test cases.
- I have added `assertj` as I think the methods are much easier to read
    - It also means it's harder to mix up `expected` and `actual` which leads to nicer failure messages.
- `lombok`: This is a controversial one but is personal preference: I like having annotation-driven boilerplate as I
  know it will be up-to-date.

## Further Changes

- I have not refactored the `Basket` class - I would leverage Dependency Injection more here
    - A `CheckoutService` or similar which would have the `DiscountService` injected and can then provide cost for
      any `Basket`
    - This would also allow for a `PaymentProvider` to be added etc.
