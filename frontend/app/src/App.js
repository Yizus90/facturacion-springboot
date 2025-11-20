import { BrowserRouter, Routes, Route } from 'react-router-dom'
import HomePage from './pages/HomePage'
import ClientesPage from './pages/ClientesPage'
import ProductosPage from './pages/ProductosPage'
import FacturasPage from './pages/FacturasPage'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/clientes" element={<ClientesPage />} />
        <Route path="/productos" element={<ProductosPage />} />
        <Route path="/facturas" element={<FacturasPage />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
