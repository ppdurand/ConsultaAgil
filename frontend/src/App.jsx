import './App.css'
import { CreateConsult } from './pages/CreateConsult/index.jsx'
import { ListPatients } from './pages/ListPatients/index.jsx'
import { RegisterPatient } from './pages/RegisterPatient/index.jsx'

function App() {
  return (
    <>
      <RegisterPatient />
      <ListPatients />
      <CreateConsult />
    </>
  )
}

export default App
