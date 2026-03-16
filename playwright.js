import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('https://www.wikipedia.org/');
  await page.getByRole('searchbox', { name: 'Search Wikipedia' }).click();
  await page.getByRole('searchbox', { name: 'Search Wikipedia' }).press('CapsLock');
  await page.getByRole('searchbox', { name: 'Search Wikipedia' }).fill('H');
  await page.getByRole('searchbox', { name: 'Search Wikipedia' }).press('CapsLock');
  await page.getByRole('searchbox', { name: 'Search Wikipedia' }).fill('Hello world');
  await page.getByRole('searchbox', { name: 'Search Wikipedia' }).press('ArrowDown');
  await page.getByRole('searchbox', { name: 'Search Wikipedia' }).press('Enter');
  await page.getByRole('link', { name: 'Pozdravljen, svet' }).click();
});