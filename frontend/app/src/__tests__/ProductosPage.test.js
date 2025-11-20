import { render, screen } from '@testing-library/react'
import ProductosPage from '../pages/ProductosPage'

test('muestra el título de productos', () => {
  render(<ProductosPage />)
  expect(screen.getByText(/Listado de Productos/i)).toBeInTheDocument()
})
